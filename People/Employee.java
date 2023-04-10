package People;

import Utils.*;
import java.time.LocalDate;

public class Employee extends Person {
    Employee(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }
}
