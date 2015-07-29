package lk.ac.ucsc.webArc.assgnment.user.api.exceptions;



/**
 * This is an Exception class used to wrap all the exceptions thrown in user related operations.
 *
 * User: Hetti

 * Time: 12:29 PM
 */
public class UserException extends Exception {

    /**
     * Construct a new UserException with the given detailed message
     *
     * @param message reason for the exception
     */
    public UserException(String message) {
        super(message);
    }

    /**
     * Construct a new UserException using the given detailed message and the thrown Exception
     *
     * @param message detailed message
     * @param e exception thrown
     */
    public UserException(String message, Exception e) {
        super(message, e);
    }
}
