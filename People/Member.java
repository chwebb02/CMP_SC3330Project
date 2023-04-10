package People;

import Utils.*;
import java.time.LocalDate;
import java.util.UUID;

import Collections.LibraryCollection;

public abstract class Member extends Person {
    // The UUID given to each library member
    private UUID id;

    // The libraryCollections that are checked out by this member
    protected CheckedOutMedia[] checkedOut;

    Member(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);

        // This needs to be tested
        id = UUID.randomUUID();
    }

    public UUID getUUID() {
        return id;
    }


}