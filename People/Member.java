package People;

import Utils.*;
import java.time.LocalDate;
import java.util.UUID;

import Collections.LibraryCollection;

public abstract class Member extends Person {
    // The UUID given to each library member
    private UUID id;

    // The libraryCollections that are checked out by this member
    protected LibraryCollection[] checkedOut;

    Member(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);

        // I'm not sure if this works
        id = new UUID(16, 0);
    }

    public UUID getUUID() {
        return id;
    }


}