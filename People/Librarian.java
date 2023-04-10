package People;

import Utils.SSN;
import java.time.LocalDate;

public class Librarian extends Employee{
    Librarian(String name, String address, String email, String password, LocalDate dob, SSN ssn) {
        super(name, address, email, password, dob, ssn);
    }
}
