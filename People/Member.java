package People;

import Utils.*;
import java.time.LocalDate;
import java.util.UUID;
import java.util.ArrayList;

import Collections.LibraryCollection;
import Utils.CheckedOutMedia;

public abstract class Member extends Person {
    // The UUID given to each library member
    private UUID id;

    // The libraryCollections that are checked out by this member
    protected ArrayList<CheckedOutMedia> checkedOut = new ArrayList<CheckedOutMedia>(5);

    Member(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);

        // This needs to be tested
        id = UUID.randomUUID();
    }

    public UUID getUUID() {
        return id;
    }

    public void checkOut(LibraryCollection media) {
        if (checkedOut.size() > 5) //If 5 already checked out return
            return;
        if (!media.checkOut())     //If media can't be checked out return
            return;

        CheckedOutMedia newMaterial = new CheckedOutMedia(media);
        checkedOut.add(newMaterial);
    }
}