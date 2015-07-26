package lk.ac.ucsc.webArc.assgnment.medicalInfo.api.beans;


import java.util.Date;

/**
 * This is the service api which used to set and get the medicalInfo related information
 *
 * User: Hetti
 * Time: 12:19 PM
 */
public interface MedicalInfo {

    String getMedicalInfoId();

    void setMedicalInfoId(String medicalInfoId);

    String getPatientNumber();

    void setPatientNumber(String patientNumber);

    String getDoctorNumber();

    void setDoctorNumber(String doctorNumber);

    Date getCreateDate();

    void setCreateDate(Date createDate);

    String getChannelId();

    void setChannelId(String channelId);

    String getDiagonasisInfo();

    void setDiagonasisInfo(String diagonasisInfo);

    String getPrescriptionInfo();

    void setPrescriptionInfo(String prescriptionInfo);
}
