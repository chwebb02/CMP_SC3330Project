package People;

import Utils.SSN;
import java.time.LocalDate;

public class Employee extends Person {
    protected Employee(String name, String address, String email, String password, LocalDate dob, SSN ssn) {
        super(name, address, email, password, dob, ssn);
    }
}
