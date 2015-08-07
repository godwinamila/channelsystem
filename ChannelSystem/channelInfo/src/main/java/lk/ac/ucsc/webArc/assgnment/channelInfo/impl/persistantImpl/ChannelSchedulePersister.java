package lk.ac.ucsc.webArc.assgnment.channelInfo.impl.persistantImpl;

import lk.ac.ucsc.webArc.assgnment.channelInfo.api.beans.ChannelSchedule;
import lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans.ChannelInfoBean;
import lk.ac.ucsc.webArc.assgnment.channelInfo.impl.beans.ChannelScheduleBean;

import java.util.List;

/**
 * Created by chamindah on 8/6/2015.
 */
public interface ChannelSchedulePersister {
    long insert(ChannelScheduleBean channelSchedule);

    void update(ChannelScheduleBean channelSchedule);

    void deleteFromDB(ChannelScheduleBean channelSchedule);

    ChannelSchedule load(String channelScheduleId);

    List<ChannelSchedule> getChannelScheduleForDoctor(String doctorNumber);

    List<ChannelSchedule> loadAll();

}
