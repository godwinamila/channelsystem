package lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web;

import java.util.Map;

import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.LoginForm;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerFactory;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerLoginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class WelcomeController {

	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		logger.debug("index() is executed!");
		LoginForm loginForm =new LoginForm();
		model.addAttribute("loginForm", loginForm);
		
		return "channelSystem";
	}




	@RequestMapping(value = "/channelDoctor", method = RequestMethod.GET)
	public String channelDoctorPage(Map<String, Object> model) {

		logger.debug("register() is executed!");
		return "channelDoctor";
	}

	@RequestMapping(value = "/channelDoctor", method = RequestMethod.POST)
	public String channelDoctor(Map<String, Object> model) {

		logger.debug("register() is executed!");
		return "searchDoctor";
	}



}