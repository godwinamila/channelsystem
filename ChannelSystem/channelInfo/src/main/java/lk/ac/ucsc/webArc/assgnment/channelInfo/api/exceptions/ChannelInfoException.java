package lk.ac.ucsc.webArc.assgnment.channelInfo.api.exceptions;



/**
 * This is an Exception class used to wrap all the exceptions thrown in channelInfo related operations.
 *
 * User: Hetti

 * Time: 12:29 PM
 */
public class ChannelInfoException extends Exception {

    /**
     * Construct a new ChannelInfoException with the given detailed message
     *
     * @param message reason for the exception
     */
    public ChannelInfoException(String message) {
        super(message);
    }

    /**
     * Construct a new ChannelInfoException using the given detailed message and the thrown Exception
     *
     * @param message detailed message
     * @param e exception thrown
     */
    public ChannelInfoException(String message, Exception e) {
        super(message, e);
    }
}
