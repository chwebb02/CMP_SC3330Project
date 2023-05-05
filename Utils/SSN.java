package Utils;

import java.io.Serializable;

public class SSN implements Serializable{
    private String ssn;

    public SSN(String ssn) {
        if (ssn.length() == 9) {
            this.ssn = ssn;
        } else {
            throw new IllegalArgumentException("Invalid ssn");
        }
    }

    public String getSSN() {
        return ssn;
    }
}
