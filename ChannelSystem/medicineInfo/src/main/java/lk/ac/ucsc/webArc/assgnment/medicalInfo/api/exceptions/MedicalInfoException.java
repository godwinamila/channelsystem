package lk.ac.ucsc.webArc.assgnment.medicalInfo.api.exceptions;



/**
 * This is an Exception class used to wrap all the exceptions thrown in medicalInfo related operations.
 *
 * User: Hetti

 * Time: 12:29 PM
 */
public class MedicalInfoException extends Exception {

    /**
     * Construct a new MedicalInfoException with the given detailed message
     *
     * @param message reason for the exception
     */
    public MedicalInfoException(String message) {
        super(message);
    }

    /**
     * Construct a new MedicalInfoException using the given detailed message and the thrown Exception
     *
     * @param message detailed message
     * @param e exception thrown
     */
    public MedicalInfoException(String message, Exception e) {
        super(message, e);
    }
}
