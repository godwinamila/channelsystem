package lk.ac.ucsc.webArc.assgnment.doctor.api.exceptions;



/**
 * This is an Exception class used to wrap all the exceptions thrown in doctors related operations.
 *
 * User: Hetti

 * Time: 12:29 PM
 */
public class DoctorException extends Exception {

    /**
     * Construct a new DoctorException with the given detailed message
     *
     * @param message reason for the exception
     */
    public DoctorException(String message) {
        super(message);
    }

    /**
     * Construct a new DoctorException using the given detailed message and the thrown Exception
     *
     * @param message detailed message
     * @param e exception thrown
     */
    public DoctorException(String message, Exception e) {
        super(message, e);
    }
}
