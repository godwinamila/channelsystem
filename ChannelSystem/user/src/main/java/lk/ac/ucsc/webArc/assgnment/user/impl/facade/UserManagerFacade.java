package lk.ac.ucsc.webArc.assgnment.user.impl.facade;


import lk.ac.ucsc.webArc.assgnment.user.api.UserManager;

import lk.ac.ucsc.webArc.assgnment.user.api.beans.User;
import lk.ac.ucsc.webArc.assgnment.user.api.beans.UserLoginProfile;

import lk.ac.ucsc.webArc.assgnment.user.api.exceptions.UserException;
import lk.ac.ucsc.webArc.assgnment.user.impl.beans.UserBean;
import lk.ac.ucsc.webArc.assgnment.user.impl.beans.UserLoginProfileBean;

import lk.ac.ucsc.webArc.assgnment.user.impl.persistantImpl.UserPersister;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * UserManagerFacade class implements all the services defined in the UserManager interface.
 * This class has a reference to the UserCacheFacade class that provides all the cache and physical storage related operations.
 * All the operations are done through UserCacheFacade.
 * <p/>
 * User: Hetti

 * Time: 2:34 PM
 */
public class UserManagerFacade implements UserManager {
    private static Logger logger = LoggerFactory.getLogger(UserManagerFacade.class);


    private UserPersister userPersister;

    public UserPersister getUserPersister() {
        return userPersister;
    }

    public void setUserPersister(UserPersister userPersister) {
        this.userPersister = userPersister;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserByUserNumber(String userNumber) throws UserException {
        logger.info("Getting the user with user number - {}", userNumber);
        if (userNumber == null || "".equalsIgnoreCase(userNumber)) {
            throw new UserException("User Number Can't be Null or Empty");
        }
        return userPersister.loadByUserNumber(userNumber);
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserByLoginNameOrAlias(String loginName) throws UserException {
        logger.info("Getting the user with login name - {}", loginName);
        if (loginName == null || "".equalsIgnoreCase(loginName)) {
            throw new UserException("User Login Name Can't be Null or Empty" );
        }

        try {
            return userPersister.loadByUserNumber(loginName);
        } catch (UserException e) {
            logger.debug("Error in getting user using login name or alias", e);
            throw new UserException("Error in getting user using login name or alias", e);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long addUser(User user) throws UserException {
        logger.info("Adding the user -{} to cache", user);
        if (user == null) {
            throw new UserException("User can't be null");
        }
        validateUser(user);

        user.getLoginProfile().setUserId(user.getUserId());

        userPersister.insert((UserBean) user);
        logger.debug("Adding user process finished");
        return user.getUserId();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUser(User user) throws UserException {
        logger.info("Update the user {}", user);
        if (user == null) {
            throw new UserException("user can't be null");
        }
        validateUser(user);

        userPersister.update((UserBean) user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void markUserAsDeleted(String userNumber) throws UserException {
        logger.info("markUserAsDeleted : userNumber : ", userNumber);
        if (userNumber == null || "".equalsIgnoreCase(userNumber)) {
            throw new UserException("User Number is Empty");
        }
        User user =getUserByUserNumber(userNumber);
        userPersister.deleteFromDB((UserBean)user);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAllUsers() throws UserException {
        logger.info("Getting All the Users");
        return userPersister.loadAll();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public User getEmptyUser(String userNumber) {
        return new UserBean(userNumber);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public UserLoginProfile getEmptyLoginProfile() {
        return new UserLoginProfileBean();
    }



    /**
     * validate user number for null or empty
     *
     * @param user
     * @throws UserException
     */
    @Override
    public void validateUser(User user) throws UserException {
        if (user.getUserNumber() == null || "".equals(user.getUserNumber())) {
            throw new UserException("User Number Can't be Null or Empty" );
        }
    }




}
