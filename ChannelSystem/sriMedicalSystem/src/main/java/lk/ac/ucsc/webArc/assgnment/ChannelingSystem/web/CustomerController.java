package lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web;

import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.service.CommonServices;
import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.LoginForm;
import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.RegisterForm;
import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.SearchDocForm;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerFactory;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerLoginManager;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerManager;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.Customer;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.LoginProfile;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.PasswordAuthentication;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

/**
 * Created by chamindah on 8/5/2015.
 */
@Controller
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private CustomerFactory customerFactory;

    private CustomerController(){
        try {
            customerFactory = CustomerFactory.getInstance();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, HttpServletRequest reg,
                        BindingResult result, Model model) {
        try {
            CustomerLoginManager loginManager = customerFactory.getCustomerLoginManager();
            CustomerManager customerManager =customerFactory.getCustomerManager();
            String loginResult = loginManager.loginCustomer(loginForm.getUserName(), loginForm.getPassword());
            if (loginResult.equalsIgnoreCase("SUCCESS")) {
                SearchDocForm searchDocForm =new SearchDocForm();
                model.addAttribute("searchDocForm",searchDocForm);
                reg.getSession().setAttribute("isAuthenticated","true");
                Customer customer=customerManager.getCustomerByCustomerNumber(loginForm.getUserName());
                reg.getSession().setAttribute("customerNumber",customer.getCustomerNumber());
                reg.getSession().setAttribute("name",customer.getFirstName() +" "+ customer.getLastName());
                return "searchDoctor";
            }
            model.addAttribute("error", loginResult);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest reg,  Model model) {
        try {
            reg.getSession().setAttribute("isAuthenticated","false");
            reg.getSession().setAttribute("customerNumber","");
            reg.getSession().setAttribute("name","");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {

        logger.debug("register() is executed!");
        RegisterForm registerForm=new RegisterForm();
        model.addAttribute("registerForm", registerForm);

        return "registerCust";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("registerForm") RegisterForm registerForm,
                             BindingResult result, Model model) {

        logger.debug("register() is executed!");
        try {
            CustomerManager customerManager = customerFactory.getCustomerManager();
            Customer customer =customerManager.getEmptyCustomer();
            customer.setMobile(registerForm.getMobile());
            customer.setLastName(registerForm.getLastName());
            customer.setTitle(registerForm.getTitle());
            customer.setIdCardNumber(registerForm.getIdCardNumber());
            customer.setOfficeTele(registerForm.getOfficeTele());
            customer.setEmail(registerForm.getEmail());
            customer.setFirstName(registerForm.getFirstName());
            customer.setGender(registerForm.getGender());

            LoginProfile loginProfile = customerManager.getEmptyLoginProfile();
            loginProfile.setStatus(2);
            loginProfile.setPassword(CommonServices.randomString(8));
            loginProfile.setLoginName(customer.getCustomerNumber());
            loginProfile.setCustomerId(customer.getCustomerId());
            customer.setLoginProfile(loginProfile);
            customerManager.addCustomer(customer);
            emailUserCredential(loginProfile.getLoginName(),loginProfile.getPassword(),(customer.getFirstName()+" "+customer.getLastName()),customer.getEmail());

        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return "redirect:/";
    }


    private void emailUserCredential(String userName, String password, String name, String toEmail){
        String title ="Welcome to SriMedical System";
        String message ="Dear "+name+"\n\n "+" Your Log in information \n\n" +"UserName :" + userName +"\nPassword :"+password;
        CommonServices.sendEmail(title,message,toEmail);

    }



}
