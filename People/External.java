package People;

import Utils.SSN;
import java.time.LocalDate;

public class External extends Member {
    External(String name, String address, String email, String password, LocalDate dob, SSN ssn) {
        super(name, address, email, password, dob, ssn);
    }
}