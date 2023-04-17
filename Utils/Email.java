package Utils;

import java.io.Serializable;

public class Email implements Serializable{
    private String emailAddress;

    public Email(String emailAddress) {
        if (isValidEmail(emailAddress)) {
            this.emailAddress = emailAddress;
        } else {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(regex);
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}