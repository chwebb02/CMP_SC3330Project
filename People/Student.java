package People;

import Utils.*;
import java.time.LocalDate;

public class Student extends Member {
    Professor mentor;

    Student(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }
}
