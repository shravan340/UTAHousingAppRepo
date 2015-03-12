package utahousing.seproject.database;

/**
 * Created by Nikhil on 3/11/2015.
 */
public class LoginDAO {

    private String myMavUserId;
    private String password;

    public LoginDAO(String myMavUserId, String password){
        this.myMavUserId=myMavUserId;
        this.password=password;
    }

    public String getMyMavUserId() {
        return myMavUserId;
    }

    public String getPassword() {
        return password;
    }

    public void setMyMavUserId(String myMavUserId) {
        this.myMavUserId = myMavUserId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
