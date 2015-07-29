package lk.ac.ucsc.webArc.assgnment.user;

import lk.ac.ucsc.webArc.assgnment.user.api.UserFactory;
import lk.ac.ucsc.webArc.assgnment.user.api.UserManager;
import lk.ac.ucsc.webArc.assgnment.user.api.beans.User;
import lk.ac.ucsc.webArc.assgnment.user.api.beans.UserLoginProfile;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by chamindah on 7/27/2015.
 */
public class UserTest {

    public static  void main(String [] args){
        try {
            UserFactory userFactory = UserFactory.getInstance();
            UserManager userManager =userFactory.getUserManager();
            User user =userManager.getEmptyUser("Cus_00001");
            user.setAddress("634/38, Govinna Road, Athurugiriya");
            user.setUserId(1);
            user.setEmail("chamhetti@gmail.com");
            user.setFirstName("Chaminda");
            user.setGender("M");
            user.setIdCardNumber("79163686v");
            user.setLastName("Hettigoda");
            user.setMobile("0722308043");
            user.setOfficeTele("011234563");
            user.setTitle("Mr.");
            UserLoginProfile loginProfile =userManager.getEmptyLoginProfile();
            loginProfile.setUserId(user.getUserId());
            loginProfile.setFailedAttemptCount(0);
            loginProfile.setLoginName(user.getEmail());
            loginProfile.setPassword("123");
            loginProfile.setPasswordExpDate(new Date());
            loginProfile.setSmsPinNumber("");
            loginProfile.setStatus(1);
            user.setLoginProfile(loginProfile);
            userManager.addUser(user);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
