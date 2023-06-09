package People;

import Utils.*;
import java.time.LocalDate;

public abstract class Employee extends Person {
    Employee(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }

    public Employee(Object emp) {
        super(emp);
    }
}
