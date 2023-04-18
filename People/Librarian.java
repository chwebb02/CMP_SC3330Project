package People;

import Utils.*;
import java.time.LocalDate;

public class Librarian extends Employee{
    public Librarian(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }

    public Librarian(Object emp) {
        super(emp);
    }
}
