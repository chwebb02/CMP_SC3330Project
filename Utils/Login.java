package Utils;

public class Login {
    private String uname, passwd;
    
    public boolean verify(Login other) {
        if (other.uname.equals(this.uname) && other.passwd.equals(this.passwd)) {
            return true;
        }

        return false;
    }
}
