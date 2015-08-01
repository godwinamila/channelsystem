package lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.persistantImpl;




import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.beans.MedicalInfo;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.exceptions.MedicalInfoException;
import lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.beans.MedicalInfoBean;

import java.util.List;

/**
 * User: Hetti

 * Time: 3:10 PM
 *
 * here are method definitions for medicalInfo persister,
 * method to delete channnelInfo from database,
 * get last medicalInfo id from database for the usage of sequence generator etc
 */
public interface MedicalInfoPersister  {

    void update(MedicalInfoBean co) throws MedicalInfoException;

    void insert(MedicalInfoBean co) throws MedicalInfoException;

    MedicalInfoBean load(String medicalInfoId) throws MedicalInfoException;

    List<MedicalInfo> loadAll();

    void deleteFromDB(MedicalInfoBean customer) throws MedicalInfoException;


    List<MedicalInfo> getMedicineInfoForCustomer(String customerNumber);

    MedicalInfo getMedicalInfoForAppointment(String channelId);

    List<MedicalInfo> getMedicineInfoForDoctor(String doctorNumber);
}
