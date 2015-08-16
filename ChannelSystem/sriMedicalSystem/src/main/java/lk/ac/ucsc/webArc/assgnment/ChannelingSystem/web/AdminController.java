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
public class AdminController {

	private final Logger logger = LoggerFactory
			.getLogger(AdminController.class);
	private CustomerFactory customerFactory;

	private AdminController() {
		try {
			customerFactory = CustomerFactory.getInstance();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public String index(Model model) {

		logger.debug("adminLogin() is executed!");
		LoginForm loginForm =new LoginForm();
		model.addAttribute("loginForm", loginForm);
		
		return "adminLogin";
	}

	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public String adminLoginPost(@Valid @ModelAttribute("loginForm") LoginForm loginForm,
			HttpServletRequest reg, BindingResult result, Model model) {
		
		//call legacy authentication service
		//here we mock the service request and hard code the staff and doctor login process
		//if userename = staff
		if(loginForm.getUserName().equals("staff")){
			return "patientHistory";
		}
		//if username = doctor
		if(loginForm.getUserName().equals("doctor")){
			return "doctor_home";
		}
	
		return "redirect:/";
	}
}
