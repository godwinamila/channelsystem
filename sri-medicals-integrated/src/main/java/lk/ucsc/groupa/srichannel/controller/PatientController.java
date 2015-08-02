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
@RequestMapping(value = "/patient")
public class PatientController {
	
	@Autowired
    private PatientDao patientDao;
	
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String displaySortedMembers(Model model) {
        model.addAttribute("newPatient", new Patient());
        model.addAttribute("patients", patientDao.findAllOrderedByName());
        return "patient/register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerNewPatient(@Valid @ModelAttribute("newPatient") Patient newPatient, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            try {
            	patientDao.register(newPatient);
                return "redirect:/";
            } catch (UnexpectedRollbackException e) {
                model.addAttribute("patients", patientDao.findAllOrderedByName());
                model.addAttribute("error", e.getCause().getCause());
                return "patient/error";
            }
        } else {
            model.addAttribute("patients", patientDao.findAllOrderedByName());
            return "patient/register";
        }
    }

}
