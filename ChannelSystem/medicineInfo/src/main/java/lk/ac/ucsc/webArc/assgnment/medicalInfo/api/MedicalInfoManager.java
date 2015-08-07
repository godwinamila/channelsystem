package lk.ac.ucsc.webArc.assgnment.medicalInfo.api;

import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.beans.MedicalInfo;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.exceptions.MedicalInfoException;


import java.util.List;

/**
 * This is the service interface to manage all the medicalInfo related information.
 * All the medicalInfo related operations should be done through this interface.
 * <p/>
 * User: Hetti

 * Time: 12:27 PM
 */
    public interface MedicalInfoManager {

    int addMedicalInfo(MedicalInfo medicalInfo) throws MedicalInfoException;

    void updateMedicalInfo(MedicalInfo medicalInfo) throws MedicalInfoException;

    void markMedicalInfoAsDeleted(String medicalInfoId) throws MedicalInfoException;

    MedicalInfo getMedicalInfo(String medicalInfoId) throws MedicalInfoException;

    List<MedicalInfo> getAllMedicalInfo() throws MedicalInfoException;

    MedicalInfo getEmptyMedicalInfo();

    List<MedicalInfo> getMedicineInfoForCustomer(String customerNumer) throws MedicalInfoException;

    MedicalInfo getMedicalInfoForAppointment(String channelId) throws MedicalInfoException;

    List<MedicalInfo> getMedicineInfoForDoctor(String doctorNumber) throws MedicalInfoException;

}

