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

import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.service.HelloWorldService;

@Controller
public class WelcomeController {

	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	private final HelloWorldService helloWorldService;

	@Autowired
	public WelcomeController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		logger.debug("index() is executed!");
		LoginForm loginForm =new LoginForm();
		model.addAttribute("loginForm", loginForm);
		
		return "channelSystem";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("loginForm") LoginForm loginForm,
						BindingResult result, Model model) {
		try {
			CustomerFactory customerFactory = CustomerFactory.getInstance();
			CustomerLoginManager loginManager =customerFactory.getCustomerLoginManager();
			String loginResult =loginManager.loginCustomer(loginForm.getUserName(),loginForm.getPassword());
			if(loginResult.equalsIgnoreCase("SUCCESS")){
				return "channelSystem";
			}
			loginForm.setErrorMsg("Invalid UserName or Password");
			model.addAttribute("error", "Invalid UserName or Password");
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Map<String, Object> model) {

		logger.debug("register() is executed!");


		return "register";
	}

	@RequestMapping(value = "/searchDoctor", method = RequestMethod.GET)
	public String searchDoctorPage(Map<String, Object> model) {

		logger.debug("register() is executed!");


		return "searchDoctor";
	}

	@RequestMapping(value = "/searchDoctor", method = RequestMethod.POST)
	public String searchDoctor(Map<String, Object> model) {

		logger.debug("register() is executed!");


		return "doctorSearchResult";
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
	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		logger.debug("hello() is executed - $name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		
		model.addObject("title", helloWorldService.getTitle(name));
		model.addObject("msg", helloWorldService.getDesc());
		
		return model;

	}

}