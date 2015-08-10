package lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web;

import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.ChannelForm;
import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.RegisterForm;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerFactory;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerManager;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.Customer;
import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorFactory;
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
import java.util.Map;

/**
 * Created by chamindah on 8/6/2015.
 */
@Controller
public class ChannelController {
    private final Logger logger = LoggerFactory.getLogger(ChannelController.class);
    private DoctorFactory doctorFactory;
    private CustomerFactory customerFactory;

    public ChannelController(){
        try {
            doctorFactory = DoctorFactory.getInstance();
            customerFactory = CustomerFactory.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/channelDoctor", method = RequestMethod.GET)
      String channelDoctorPage(Model model, HttpServletRequest reg) {
        try {
            String doctorNum = reg.getParameter("doctorNumber");
            DoctorManager doctorManager = doctorFactory.getDoctorManager();
            Doctor doctor = doctorManager.getDoctorByDoctorNumber(doctorNum);
            CustomerManager customerManager =customerFactory.getCustomerManager();
            Customer customer =customerManager.getCustomerByCustomerNumber((String)reg.getSession().getAttribute("customerNumber"));
            ChannelForm channelForm =new ChannelForm();
            channelForm.setDoctorName(doctor.getFirstName()+" " + doctor.getLastName());
            channelForm.setSpeciality(doctor.getSpeciality());
            channelForm.setPatientName(customer.getFirstName()+ " "+ customer.getLastName());
            channelForm.setNicNumber(customer.getIdCardNumber());
            channelForm.setTelePhone(customer.getMobile());
            channelForm.setRoomNo("10");
            channelForm.setAppntNumber("5");
            model.addAttribute("channelForm",channelForm);
            logger.debug("register() is executed!");
        }catch (Exception e){

        }
        return "channelDoctor";
    }




    @RequestMapping(value = "/channelDoctor", method = RequestMethod.POST)
    public String channelDoctor(@ModelAttribute("channelForm") ChannelForm channelForm,
                                BindingResult result, Model model) {

        logger.debug("register() is executed!");
        return "searchDoctor";
    }

}
