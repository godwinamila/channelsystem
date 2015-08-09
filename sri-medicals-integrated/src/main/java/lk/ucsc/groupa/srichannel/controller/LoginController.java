package lk.ucsc.groupa.srichannel.controller;

import javax.validation.Valid;

import lk.ucsc.groupa.srichannel.data.PatientDao;
import lk.ucsc.groupa.srichannel.model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	@Autowired
	private PatientDao patientDao;

	@RequestMapping(value = "/patient/login", method = RequestMethod.GET)
	public String getPatientLogin(Model model) {
		model.addAttribute("patient", new Patient());
		return "/patient/login";
	}

	@RequestMapping(value = "/patient/login", method = RequestMethod.POST)
	public String postPatientLogin(@Valid @ModelAttribute("patient") Patient patient,
			BindingResult result, Model model) {
		if (!result.hasErrors()) {
			try {
            	Patient loggedInPatient = patientDao.findByEmail(patient.getEmail());
            	if(loggedInPatient != null && loggedInPatient.getPassword().equals(patient.getPassword())){
	            	model.addAttribute("loggedInPatient", loggedInPatient);
	        		return "/patient/home";
            	}else{
            		model.addAttribute("error", "Invalid email or password");
            		return "/patient/login";
            	}
            } catch (UnexpectedRollbackException e) {
                model.addAttribute("error", e.getCause().getCause());
                return "patient/error";
            }
		} else {
			return "/patient/login";
		}
	}

	@RequestMapping(value = "/patient/changepassword", method = RequestMethod.GET)
	public String getChangePassword(Model model) {
		model.addAttribute("patient", new Patient());
		return "/patient/changepassword";
	}

}
