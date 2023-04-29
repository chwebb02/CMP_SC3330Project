package People;

import Utils.*;
import java.time.LocalDate;
import java.util.UUID;
import java.util.ArrayList;

import Collections.LibraryCollection;

public abstract class Member extends Person {
    // The UUID given to each library member
    private UUID id;

    // The libraryCollections that are checked out by this member
    protected ArrayList<LibraryCollection> checkedOut = new ArrayList<LibraryCollection>(5);

    public Member(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);

        // This needs to be tested
        id = UUID.randomUUID();
    }

    public Member(Object mem) {
        super(mem);
    }

    public UUID getUUID() {
        return id;
    }

    public boolean checkOut(LibraryCollection media) {
        if (checkedOut.size() > 5) //If 5 already checked out return
            return false;
        if (!media.checkOut(this))     //If media can't be checked out return
            return false;

        checkedOut.add(media);
        return true;
    }

    public boolean returnMedia(LibraryCollection media) {
        if (!checkedOut.contains(media)) //If not in collection can't be returned
            return false;

        Technician.recieveMedia(media);
        return true;
    }
}