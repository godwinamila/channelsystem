package lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans;

import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelSchedule;

import java.util.Date;

/**
 * Created by chamindah on 8/6/2015.
 */
public class ChannelScheduleBean implements ChannelSchedule {
    private int chanScheId;
    private String doctorNumber;
    private Date channelDate;
    private String roomNumber;
    private String startTime;
    private int appointmentNumber;
    private int maxAppointment;

    @Override
    public int getChanScheId() {
        return chanScheId;
    }

    @Override
    public void setChanScheId(int chanScheId) {
        this.chanScheId = chanScheId;
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
    public Date getChannelDate() {
        return channelDate;
    }

    @Override
    public void setChannelDate(Date channelDate) {
        this.channelDate = channelDate;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public int getAppointmentNumber() {
        return appointmentNumber;
    }

    @Override
    public void setAppointmentNumber(int appointmentNumber) {
        this.appointmentNumber = appointmentNumber;
    }

    @Override
    public int getMaxAppointment() {
        return maxAppointment;
    }

    @Override
    public void setMaxAppointment(int maxAppointment) {
        this.maxAppointment = maxAppointment;
    }

    @Override
    public String getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
