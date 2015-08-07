package lk.ac.ucsc.webArc.assgnment.channelInfo.api.exceptions;

/**
 * Created by chamindah on 8/6/2015.
 */
public class ChannelScheduleException extends Exception {

    /**
     * Construct a new ChannelInfoException with the given detailed message
     *
     * @param message reason for the exception
     */
    public ChannelScheduleException(String message) {
        super(message);
    }

    /**
     * Construct a new ChannelInfoException using the given detailed message and the thrown Exception
     *
     * @param message detailed message
     * @param e exception thrown
     */
    public ChannelScheduleException(String message, Exception e) {
        super(message, e);
    }
}
