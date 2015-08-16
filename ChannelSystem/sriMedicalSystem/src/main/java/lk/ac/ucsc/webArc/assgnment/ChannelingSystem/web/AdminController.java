package lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web;

import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.service.CommonServices;
import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.*;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerFactory;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerLoginManager;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerManager;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.Customer;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.LoginProfile;

import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorLoginManager;
import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorManager;
import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.Doctor;
import lk.ac.ucsc.webArc.assgnment.user.api.UserFactory;
import lk.ac.ucsc.webArc.assgnment.user.api.UserLoginManager;
import lk.ac.ucsc.webArc.assgnment.user.api.UserManager;
import lk.ac.ucsc.webArc.assgnment.user.api.beans.User;
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
public class AdminController {

	private final Logger logger = LoggerFactory
			.getLogger(AdminController.class);
	private UserFactory userFactory;

	private AdminController() {
		try {
			userFactory = UserFactory.getInstance();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public String index(Model model) {

		logger.debug("adminLogin() is executed!");
		UserTypeForm userTypeForm =new UserTypeForm();
		model.addAttribute("userTypeForm", userTypeForm);
		
		return "adminLogin";
	}

	@RequestMapping(value = "/selectUser", method = RequestMethod.POST)
	public String adminLoginPost(@Valid @ModelAttribute("userTypeForm") UserTypeForm userTypeForm,
			HttpServletRequest reg, BindingResult result, Model model) {
		
		//call legacy authentication service
		//here we mock the service request and hard code the staff and doctor login process
		//if userename = staff
		LoginForm loginForm =new LoginForm();
		model.addAttribute("loginForm",loginForm);
		if(userTypeForm.getUserType().equals("Doctor")){
			return "doctorLogin";
		}
		//if username = doctor
		if(userTypeForm.getUserType().equals("Staff")){
			return "staffLogin";
		}
	
		return "redirect:/";
	}

	@RequestMapping(value = "/staffLogin", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, HttpServletRequest reg,
						BindingResult result, Model model) {
		try {
			UserManager userManager = userFactory.getUserManager();
			UserLoginManager userLoginManager =userFactory.getUserLoginManager();
			String loginResult = userLoginManager.loginUser(loginForm.getUserName(), loginForm.getPassword());
			if (loginResult.equalsIgnoreCase("SUCCESS")) {
				SearchDocForm searchDocForm =new SearchDocForm();
				model.addAttribute("searchDocForm",searchDocForm);
				reg.getSession().setAttribute("isAuthenticated","true");
				User user=userManager.getUserByLoginNameOrAlias(loginForm.getUserName());
				reg.getSession().setAttribute("customerNumber",user.getUserNumber());
				reg.getSession().setAttribute("userType", "staff");
				reg.getSession().setAttribute("name",user.getFirstName() +" "+ user.getLastName());
				PatientHistoryForm patientHistoryForm = new PatientHistoryForm();
				model.addAttribute("patientHistoryForm", patientHistoryForm);
				return "staff_home";
			}
			model.addAttribute("error", loginResult);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "redirect:/";
	}

}
