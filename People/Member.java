package People;

import Utils.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Member extends Person {
    UUID id;
    ArrayList<char[]> checkedCollections;  // Array of LibraryCollection identifiers checked out by Member (Initial Fix)

    Member(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);

        // I'm not sure if this works
        id = new UUID(16, 0);
    }
}