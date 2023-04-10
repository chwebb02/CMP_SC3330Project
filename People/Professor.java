package People;

import Utils.SSN;
import java.time.LocalDate;
import java.util.ArrayList;

public class Professor extends Member {
    ArrayList<Student> mentees;

    Professor(String name, String address, String email, String password, LocalDate dob, SSN ssn) {
        super(name, address, email, password, dob, ssn);
    }
}
