package lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans;


import java.util.Date;

/**
 * This is the service api which used to set and get the channelInfo related information
 *
 * User: Hetti
 * Time: 12:19 PM
 */
public interface ChannelInfo {

    int getChannelInfoId();

    void setChannelInfoId(int channelInfoId);

    String getPatientNumber();

    void setPatientNumber(String patientNumber);

    String getDoctorNumber();

    void setDoctorNumber(String doctorNumber);

    Date getCreateDate();

    void setCreateDate(Date createDate);

    String getTimeSlot();

    void setTimeSlot(String timeSlot);

    int getChannelStatus();

    void setChannelStatus(int channelStatus);

    String getLocation();

    void setLocation(String location);

    String getChannelDate();

    void setChannelDate(String channelDate);
}
