package lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.LoginForm;
import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.SearchDocForm;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.ChannelInfoFactory;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.ChannelInfoManager;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.ChannelScheduleManager;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelInfo;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelSchedule;
import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorFactory;
import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorLoginManager;
import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorManager;
import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.Doctor;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.MedicalInfoFactory;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.MedicalInfoManager;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.beans.MedicalInfo;

import lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.beans.MedicalInfoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chamindah on 8/5/2015.
 */
@Controller
public class DoctorController {
    private final Logger logger = LoggerFactory.getLogger(DoctorController.class);
    private DoctorFactory doctorFactory;
    private ChannelInfoFactory channelInfoFactory;
    private MedicalInfoFactory medInfoFactory;

    private DoctorController() {
        try {
            doctorFactory = DoctorFactory.getInstance();
            channelInfoFactory = ChannelInfoFactory.getInstance();
            medInfoFactory = MedicalInfoFactory.getInstance();
            
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
                reg.getSession().setAttribute("docNumber",doctor.getDoctorNumber());
                reg.getSession().setAttribute("userType", "doctor");
                reg.getSession().setAttribute("name",doctor.getFirstName() +" "+ doctor.getLastName());
                ChannelScheduleManager channelScheduleManager = channelInfoFactory.getChannelScheduleManager();
                List<ChannelSchedule> channelScheduleList =channelScheduleManager.getChannelScheduleForDoctor(doctor.getDoctorNumber());
                model.addAttribute("lists",channelScheduleList);
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
    
    @RequestMapping(value = "/doctor_home", method = RequestMethod.GET)
    String channelDoctorPage(Model model, HttpServletRequest reg) {
        try {
            String doctorNum = (String) reg.getSession().getAttribute("docNumber");
            String message =(String)reg.getAttribute("message");
            if(message!=null && !message.isEmpty()){
                model.addAttribute("message", message);
            }
            ChannelScheduleManager channelScheduleManager = channelInfoFactory.getChannelScheduleManager();
            List<ChannelSchedule> channelScheduleList= channelScheduleManager.getChannelScheduleForDoctor(doctorNum);
            model.addAttribute("lists", channelScheduleList);
            logger.debug("channelDoctorPage() is executed!");
        }catch (Exception e){
        	e.printStackTrace();
        }
        return "doctor_home";
    }
    
    
    @RequestMapping(value = "/viewAppointments", method = RequestMethod.GET)
    String viewDoctorAppointments(Model model, HttpServletRequest reg) {
        try {
            String channelId = reg.getParameter("channelId");
            ChannelScheduleManager channelScheduleManager = channelInfoFactory.getChannelScheduleManager();
            ChannelInfoManager channelInfoManager = channelInfoFactory.getChannelInfoManager();
            List<ChannelInfo> channelInfoList= channelInfoManager.getChannelInfoByScheduleId(channelId);
            model.addAttribute("lists", channelInfoList);
            ChannelSchedule schedule = channelScheduleManager.getChannelSchedule(channelId);
            model.addAttribute("schedule", schedule);
            logger.debug("channelDoctorPage() is executed!");
        }catch (Exception e){
        	e.printStackTrace();
        }
        return "viewAppointments";
    }
    
    @RequestMapping(value = "/newTreatment", method = RequestMethod.GET)
    String getNewTreatment(Model model, HttpServletRequest req) {
        try {
            String channelId = req.getParameter("channelId");
            String docId = req.getParameter("docId");
            String custId = req.getParameter("custId");
            MedicalInfoManager medInfoManager = medInfoFactory.getMedicalInfoManager();
            MedicalInfo treatment = medInfoManager.getMedicalInfoForAppointment(channelId);
            if(treatment == null){
            	treatment = medInfoManager.getEmptyMedicalInfo();
            	treatment.setChannelId(channelId);
            	treatment.setDoctorNumber(docId);
            	treatment.setPatientNumber(custId);
            }
            model.addAttribute("treatment", treatment);
            logger.debug("channelDoctorPage() is executed!");
        }catch (Exception e){
        	e.printStackTrace();
        }
        return "newTreatment";
    }
    
    @RequestMapping(value = "/newTreatment", method = RequestMethod.POST)
    public String postNewTreatment(@Valid @ModelAttribute("treatment") MedicalInfoBean treatment,
                               BindingResult result, Model model, HttpServletRequest req ) {

        logger.debug("register() is executed!");
        try{
        	MedicalInfoManager medInfoManager = medInfoFactory.getMedicalInfoManager();
        	treatment.setCreateDate(new Date());
            ChannelInfoManager channelInfoManager =channelInfoFactory.getChannelInfoManager();
            ChannelInfo channelInfo =channelInfoManager.getChannelInfo(treatment.getChannelId());
            channelInfo.setChannelStatus(2);
            channelInfoManager.updateChannelInfo(channelInfo);
        	if(treatment.getMedicalInfoId() == 0){
        		medInfoManager.addMedicalInfo(treatment);
        	}else{
        		medInfoManager.updateMedicalInfo(treatment);
        	}
            req.setAttribute("message", "Treatment Add successfully");
            return "redirect:/doctor_home?message=Treatment Add successfully";
        	
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return "redirect:/doctor_home?message=Treatment Add Fail";
        }


    }

}
