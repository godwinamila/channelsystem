package lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.PatientHistoryForm;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerFactory;
import lk.ac.ucsc.webArc.assgnment.customer.api.CustomerManager;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.MedicalInfoFactory;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.MedicalInfoManager;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.beans.MedicalInfo;
import lk.ac.ucsc.webArc.assgnment.customer.api.beans.customer.Customer;
import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorFactory;
import lk.ac.ucsc.webArc.assgnment.doctor.api.DoctorManager;
import lk.ac.ucsc.webArc.assgnment.doctor.api.beans.Doctor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Lahiru on 13/08/2015.
 */
@Controller
public class PatientHistoryController {
    private final Logger logger = LoggerFactory.getLogger(PatientHistoryController.class);
    private MedicalInfoFactory medInfoFactory;
    private CustomerFactory customerFactory;
    private DoctorFactory doctorFactory;

    private PatientHistoryController() {
        try {
        	medInfoFactory = MedicalInfoFactory.getInstance();
        	customerFactory = CustomerFactory.getInstance();
        	doctorFactory = DoctorFactory.getInstance();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/patientHistory", method = RequestMethod.GET)
    public String patientHistoryGetPage(Model model) {

        logger.debug("patientHistory() is executed!");
        PatientHistoryForm patientHistoryForm = new PatientHistoryForm();
        model.addAttribute("patientHistoryForm", patientHistoryForm);
        return "staff_home";
    }

    @RequestMapping(value = "/patientHistory", method = RequestMethod.POST)
    public String patientHistoryPostPage(@Valid @ModelAttribute("patientHistoryForm") PatientHistoryForm patientHistoryForm,
                               BindingResult result, Model model) {

    	try{
	        logger.debug("patientHistory() is executed!");
	        MedicalInfoManager medInfoManager = medInfoFactory.getMedicalInfoManager();
	        CustomerManager custManager = customerFactory.getCustomerManager();
	        String custNo =patientHistoryForm.getCustomerNumber();
	        Customer cust = custManager.getCustomerByCustomerNumber(custNo);
	        String fromDate = patientHistoryForm.getFromDate();
	        String toDate = patientHistoryForm.getToDate();
	        List<MedicalInfo> medicalRecordslist = medInfoManager.getMedicineInfoForCustomer(custNo, fromDate, toDate);
	        model.addAttribute("medicalRecordslist", medicalRecordslist);
	        model.addAttribute("patientId", custNo);
	        model.addAttribute("patientName", cust.getFirstName() + " "+cust.getLastName());
	        return "patientHistoryResult";
    	}catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return "redirect:/";
    	
    }
    
    @RequestMapping(value = "/viewMedicalRecord", method = RequestMethod.GET)
    public String patientHistoryDetailPage(Model model, HttpServletRequest req) {
    	try{
	        logger.debug("patientHistory() is executed!");
	        String medicalInfoId = req.getParameter("id");
	        MedicalInfoManager medInfoManager = medInfoFactory.getMedicalInfoManager();
	        MedicalInfo medicalRecord = medInfoManager.getMedicalInfo(medicalInfoId);
	        CustomerManager custManager = customerFactory.getCustomerManager();
	        String custNo =medicalRecord.getPatientNumber();
	        Customer cust = custManager.getCustomerByCustomerNumber(custNo);
	        DoctorManager docManager = doctorFactory.getDoctorManager();
	        Doctor doc = docManager.getDoctorByDoctorNumber(medicalRecord.getDoctorNumber());
	        model.addAttribute("medicalRecord", medicalRecord);
	        model.addAttribute("patientName", cust.getFirstName() + " "+cust.getLastName());
	        model.addAttribute("docName", doc.getFirstName() + " "+doc.getLastName());
	        return "viewMedicalRecord";
    	}catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return "redirect:/";
    }
}
