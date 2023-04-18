package People;

import Utils.SSN;
import Utils.Email;
import Utils.Login;
import java.time.LocalDate;

public class External extends Member {
    public External(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }

    public External(Object mem) {
        super(mem);
    }
}