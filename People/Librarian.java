package People;

import Utils.*;
import java.time.LocalDate;

public class Librarian extends Employee{
    Librarian(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }

    public void menu() {
        // TODO
    }
}
