package People;

import Utils.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Professor extends Member {
    ArrayList<Student> mentees;

    Professor(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }
}
