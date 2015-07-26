package lk.ac.ucsc.webArc.assgnment.medicalInfo.impl.beans;

import lk.ac.ucsc.webArc.assgnment.medicalInfo.api.beans.MedicalInfo;
import java.util.Date;

/**
 * User: Hetti
 * Time: 9:27 AM
 * <p>
 * implementation fo medicalInfo interface with relevant variables
 */

public class MedicalInfoBean implements MedicalInfo {
    private String medicalInfoId;
    private String patientNumber;
    private String doctorNumber;
    private Date createDate;
    private String channelId;
    private String diagonasisInfo;
    private String prescriptionInfo;


    @Override
    public String getMedicalInfoId() {
        return medicalInfoId;
    }

    @Override
    public void setMedicalInfoId(String medicalInfoId) {
        this.medicalInfoId = medicalInfoId;
    }

    @Override
    public String getPatientNumber() {
        return patientNumber;
    }

    @Override
    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    @Override
    public String getDoctorNumber() {
        return doctorNumber;
    }

    @Override
    public void setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String getChannelId() {
        return channelId;
    }

    @Override
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String getDiagonasisInfo() {
        return diagonasisInfo;
    }

    @Override
    public void setDiagonasisInfo(String diagonasisInfo) {
        this.diagonasisInfo = diagonasisInfo;
    }

    @Override
    public String getPrescriptionInfo() {
        return prescriptionInfo;
    }

    @Override
    public void setPrescriptionInfo(String prescriptionInfo) {
        this.prescriptionInfo = prescriptionInfo;
    }
}
