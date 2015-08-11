package lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web;

import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.service.CommonServices;
import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.ChannelForm;
import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.RegisterForm;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.ChannelInfoFactory;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.ChannelInfoManager;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.ChannelScheduleManager;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelInfo;
import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelSchedule;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chamindah on 8/6/2015.
 */
@Controller
public class ChannelController {
    private final Logger logger = LoggerFactory.getLogger(ChannelController.class);
    private DoctorFactory doctorFactory;
    private CustomerFactory customerFactory;
    private ChannelInfoFactory channelInfoFactory;

    public ChannelController(){
        try {
            doctorFactory = DoctorFactory.getInstance();
            customerFactory = CustomerFactory.getInstance();
            channelInfoFactory= ChannelInfoFactory.getInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/channelDoctorConfirm", method = RequestMethod.GET)
      String channelDoctorConfPage(Model model, HttpServletRequest reg) {
        try {
            SimpleDateFormat sdf =new SimpleDateFormat("YYYY/MM/DD");
            String channelId = reg.getParameter("channelId");
            ChannelScheduleManager channelScheduleManager =channelInfoFactory.getChannelScheduleManager();
            ChannelSchedule channelSchedule =channelScheduleManager.getChannelSchedule(channelId);
            DoctorManager doctorManager = doctorFactory.getDoctorManager();
            Doctor doctor = doctorManager.getDoctorByDoctorNumber(channelSchedule.getDoctorNumber());
            CustomerManager customerManager =customerFactory.getCustomerManager();
            Customer customer =customerManager.getCustomerByCustomerNumber((String)reg.getSession().getAttribute("customerNumber"));
            ChannelForm channelForm =new ChannelForm();
            channelForm.setDoctorName(doctor.getFirstName()+" " + doctor.getLastName());
            channelForm.setSpeciality(doctor.getSpeciality());
            channelForm.setPatientName(customer.getFirstName()+ " "+ customer.getLastName());
            channelForm.setNicNumber(customer.getIdCardNumber());
            channelForm.setTelePhone(customer.getMobile());
            channelForm.setRoomNo(channelSchedule.getRoomNumber());
            channelForm.setAppntNumber(""+ (channelSchedule.getAppointmentNumber()+1));
            channelForm.setChannelDate(sdf.format(channelSchedule.getChannelDate()));
            channelForm.setTimeSlot("Start At: "+channelSchedule.getStartTime());
            channelForm.setCustomerNumber(customer.getCustomerNumber());
            channelForm.setChannelSheId(""+channelSchedule.getChanScheId());
            channelForm.setDoctorNumber(doctor.getDoctorNumber());
            model.addAttribute("channelForm", channelForm);
            logger.debug("register() is executed!");
        }catch (Exception e){

        }
        return "channelDoctorConfirm";
    }

    @RequestMapping(value = "/channelDoctor", method = RequestMethod.GET)
    String channelDoctorPage(Model model, HttpServletRequest reg) {
        try {
            String doctorNum = reg.getParameter("doctorNumber");
            ChannelScheduleManager channelScheduleManager = channelInfoFactory.getChannelScheduleManager();
            List<ChannelSchedule> channelScheduleList= channelScheduleManager.getChannelScheduleForDoctor(doctorNum);
            model.addAttribute("scheList", channelScheduleList);
            model.addAttribute("lists", channelScheduleList);
            logger.debug("register() is executed!");
        }catch (Exception e){

        }
        return "doctorSchedule";
    }



    @RequestMapping(value = "/channelDoctorConfirm", method = RequestMethod.POST)
    public String channelDoctor(@ModelAttribute("channelForm") ChannelForm channelForm,
                                BindingResult result, Model model) {
        try {
            logger.debug("register() is executed!");
            ChannelInfoManager channelInfoManager = channelInfoFactory.getChannelInfoManager();
            ChannelInfo channelInfo = channelInfoManager.getEmptyChannelInfo();
            channelInfo.setPatientNumber(channelForm.getCustomerNumber());
            channelInfo.setTimeSlot(channelForm.getTimeSlot());
            channelInfo.setLocation(channelForm.getRoomNo());
            channelInfo.setDoctorNumber(channelForm.getDoctorNumber());
            channelInfo.setChannelStatus(1);
            channelInfo.setCreateDate(new Date());
            channelInfoManager.addChannelInfo(channelInfo);
            ChannelScheduleManager channelScheduleManager = channelInfoFactory.getChannelScheduleManager();
            ChannelSchedule channelSchedule =channelScheduleManager.getChannelSchedule(channelForm.getChannelSheId());
            channelSchedule.setAppointmentNumber(channelSchedule.getAppointmentNumber() +1);
            channelScheduleManager.updateChannelSchedule(channelSchedule);
            emailUserCredential(channelForm.getCustomerNumber(),channelSchedule,channelForm.getDoctorName());
        } catch (Exception e) {

        }
        return "redirect:/searchDoctor";
    }

    private void emailUserCredential(String customerNumber, ChannelSchedule channelSchedule, String doctorName){
        try {
            String title = "Sri Medical - Channeling Confirmation";
            Customer customer = customerFactory.getCustomerManager().getCustomerByCustomerNumber(customerNumber);
            String message = "Dear " + customer.getFirstName()+" " +customer.getLastName() + "\n\n " + " Channel Information \n\n" + "Doctor :" + doctorName + "\nDate :" + channelSchedule.getChannelDate()+
                    "\nTime(start at):"+channelSchedule.getStartTime()+"\nRoom No:"+ channelSchedule.getRoomNumber()+"\nAppointment Number:"+ channelSchedule.getAppointmentNumber();
            CommonServices.sendEmail(title, message, customer.getEmail());
        }catch (Exception e){

        }

    }

}
