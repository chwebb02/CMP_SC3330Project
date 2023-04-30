package Utils;

import java.io.Serializable;

public class Login implements Serializable {

    private String uname, passwd;
    
    public Login(String uname, String passwd) {
        this.uname = uname;
        this.passwd = passwd;
    }

    public boolean verify(Login other) {
        if (other.uname.equals(this.uname) && other.passwd.equals(this.passwd)) {
            return true;
        }

        return false;
    }

    public String getUsername() {
        return uname;
    }
}
