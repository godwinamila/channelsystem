package lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans;

import java.util.Date;

/**
 * Created by chamindah on 8/6/2015.
 */
public interface ChannelSchedule {
    int getChanScheId();

    void setChanScheId(int chanScheId);

    String getDoctorNumber();

    void setDoctorNumber(String doctorNumber);

    Date getChannelDate();

    void setChannelDate(Date channelDate);

    String getRoomNumber();

    void setRoomNumber(String roomNumber);

    int getAppointmentNumber();

    void setAppointmentNumber(int appointmentNumber);

    int getMaxAppointment();

    void setMaxAppointment(int maxAppointment);

    String getStartTime();

    void setStartTime(String startTime);
}
