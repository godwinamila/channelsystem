package lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans;

import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelInfo;
import java.util.Date;

/**
 * User: Hetti
 * Time: 9:27 AM
 * <p>
 * implementation fo channelInfo interface with relevant variables
 */

public class ChannelInfoBean implements ChannelInfo {
    private int channelInfoId;
    private String patientNumber;
    private String doctorNumber;
    private String channelDate;
    private Date createDate;
    private String timeSlot;
    private int channelStatus;
    private String location;

    @Override
    public int getChannelInfoId() {
        return channelInfoId;
    }

    @Override
    public void setChannelInfoId(int channelInfoId) {
        this.channelInfoId = channelInfoId;
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
    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public int getChannelStatus() {
        return channelStatus;
    }

    @Override
    public void setChannelStatus(int channelStatus) {
        this.channelStatus = channelStatus;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getChannelDate() {
        return channelDate;
    }

    @Override
    public void setChannelDate(String channelDate) {
        this.channelDate = channelDate;
    }
}
