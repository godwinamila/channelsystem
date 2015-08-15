package lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms.PatientHistoryForm;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.MedicalInfoFactory;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.MedicalInfoManager;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.beans.MedicalInfo;

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

    private PatientHistoryController() {
        try {
        	medInfoFactory = MedicalInfoFactory.getInstance();
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
	        String custNo =patientHistoryForm.getCustomerNumber();
	        String fromDate = patientHistoryForm.getFromDate();
	        String toDate = patientHistoryForm.getToDate();
	        List<MedicalInfo> medicalRecordslist = medInfoManager.getMedicineInfoForCustomer(custNo, fromDate, toDate);
	        model.addAttribute("medicalRecordslist", medicalRecordslist);
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
	        model.addAttribute("medicalRecord", medicalRecord);
	        return "viewMedicalRecord";
    	}catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return "redirect:/";
    }
}
