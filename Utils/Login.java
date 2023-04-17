package Utils;

public class Login {
    private String uname, passwd;
    

   public Login(String name, String Pass)
    {
        this.uname=name;
        this.passwd=Pass;
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
