package lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web;

import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.LoginForm;
import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.RegisterForm;
import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.SearchDocForm;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerLoginManager;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerManager;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.Customer;
import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorFactory;
import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorLoginManager;
import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorManager;
import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.Doctor;
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
import java.util.List;
import java.util.Map;

/**
 * Created by chamindah on 8/5/2015.
 */
@Controller
public class DoctorController {
    private final Logger logger = LoggerFactory.getLogger(DoctorController.class);
    private DoctorFactory doctorFactory;

    private DoctorController() {
        try {
            doctorFactory = DoctorFactory.getInstance();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/doctorLogin", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, HttpServletRequest reg,
                        BindingResult result, Model model) {
        try {
            DoctorLoginManager loginManager = doctorFactory.getDoctorLoginManager();
            DoctorManager doctorManager =doctorFactory.getDoctorManager();
            String loginResult = loginManager.loginDoctor(loginForm.getUserName(), loginForm.getPassword());
            if (loginResult.equalsIgnoreCase("SUCCESS")) {
                SearchDocForm searchDocForm =new SearchDocForm();
                model.addAttribute("searchDocForm",searchDocForm);
                reg.getSession().setAttribute("isAuthenticated","true");
                Doctor doctor=doctorManager.getDoctorByLoginNameOrAlias(loginForm.getUserName());
                reg.getSession().setAttribute("customerNumber",doctor.getDoctorNumber());
                reg.getSession().setAttribute("userType", "doctor");
                reg.getSession().setAttribute("name",doctor.getFirstName() +" "+ doctor.getLastName());
                return "doctor_home";
            }
            model.addAttribute("error", loginResult);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/searchDoctor", method = RequestMethod.GET)
    public String searchDoctorPage(Model model) {

        logger.debug("register() is executed!");
        SearchDocForm searchDocForm = new SearchDocForm();
        model.addAttribute("searchDocForm", searchDocForm);
        return "searchDoctor";
    }

    @RequestMapping(value = "/searchDoctor", method = RequestMethod.POST)
    public String searchDoctor(@Valid @ModelAttribute("searchDocForm") SearchDocForm searchDocForm,
                               BindingResult result, Model model) {

        logger.debug("register() is executed!");
        DoctorManager doctorManager = doctorFactory.getDoctorManager();
        String lastName = searchDocForm.getLastName();
        String speciality = searchDocForm.getSpeciality();
        List<Doctor> doctorList;
        if (speciality != null) {
            doctorList = doctorManager.getDoctorBySpeciality(speciality);
            if (lastName != null && !lastName.equalsIgnoreCase("")) {
                for (Doctor doctor : doctorList) {
                    if (!doctor.getLastName().equalsIgnoreCase(lastName)) {
                        doctorList.remove(doctor);
                    }
                }
            }
        } else {
            doctorList = doctorManager.getAllDoctors();
        }

        model.addAttribute("lists", doctorList);
        return "doctorSearchResult";
    }
}
