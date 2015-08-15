package lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms;

/**
 * Created by chamindah on 8/15/2015.
 */
public class ChannelHistoryForm {
    private String channelDate;
    private String doctorName;
    private String timeSlot;
    private String channelId;
    private String status;
    private String speciality;

    public String getChannelDate() {
        return channelDate;
    }

    public void setChannelDate(String channelDate) {
        this.channelDate = channelDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
