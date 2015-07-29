package lk.ac.ucsc.webArc.assgnment.user.api;

import lk.ac.ucsc.webArc.assgnment.user.api.beans.User;
import lk.ac.ucsc.webArc.assgnment.user.api.beans.UserLoginProfile;
import lk.ac.ucsc.webArc.assgnment.user.api.exceptions.UserException;


import java.util.List;

/**
 * This is the service interface to manage all the user related information.
 * All the user related operations should be done through this interface.
 * <p/>
 * User: Hetti

 * Time: 12:27 PM
 */
public interface UserManager {


    User getUserByUserNumber(String userNumber) throws UserException;

    User getUserByLoginNameOrAlias(String loginName) throws UserException;

    long addUser(User user) throws UserException;

    void updateUser(User user) throws UserException;

    void markUserAsDeleted(String userNumber) throws UserException;

    List<User> getAllUsers() throws UserException;

    User getEmptyUser(String userNumber);

    UserLoginProfile getEmptyLoginProfile();

    void validateUser(User user) throws UserException;
}

