package lk.ac.ucsc.webArc.assgnment.ChannelingSystem.web.forms;

/**
 * Created by chamindah on 8/1/2015.
 */
public class LoginForm {
    private String userName;
    private String password;
    private String errorMsg;

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

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
