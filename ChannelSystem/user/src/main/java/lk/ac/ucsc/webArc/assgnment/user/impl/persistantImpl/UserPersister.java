package lk.ac.ucsc.webArc.assgnment.user.impl.persistantImpl;


import lk.ac.ucsc.webArc.assgnment.user.api.beans.User;
import lk.ac.ucsc.webArc.assgnment.user.api.exceptions.UserException;
import lk.ac.ucsc.webArc.assgnment.user.impl.beans.UserBean;

import java.util.List;

/**
 * User: Hetti

 * Time: 3:10 PM
 *
 * here are method definitions for user persister,
 * method to delete users from database,
 * get last user id from database for the usage of sequence generator etc
 */
public interface UserPersister  {

    void update(UserBean co) throws UserException;

    void insert(UserBean co) throws UserException;

    UserBean load(String userNumber) throws UserException;

    List<User> loadAll();

    void deleteFromDB(UserBean user) throws UserException;

    String getLastUserId() throws UserException;

    UserBean loadByUserNumber(String userNumber) throws UserException;
}
