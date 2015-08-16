package lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * Created by chamindah on 8/1/2015.
 */
public class LoginForm {
    @NotEmpty(message = "user name cannot be empty")
    private String userName;
    @NotEmpty(message = "password cannot be empty")
    private String password;

    private String userType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
