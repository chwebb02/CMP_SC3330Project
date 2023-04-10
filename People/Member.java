package People;

import Utils.SSN;
import java.time.LocalDate;
import java.util.ArrayList;

public class Member extends Person {
    int UID;
    ArrayList<char[]> checkedCollections;  //Array of LibraryCollection identifiers checked out by Member (Initial Fix)

    Member(String name, String address, String email, String password, LocalDate dob, SSN ssn) {
        super(name, address, email, password, dob, ssn);
        UID = hashCode(name, address, email, dob); // Generate UID off of information
    }

    @Override
    public int hashCode() {
        return (int) name.hashCode() * address.hashCode() * email.hashCode() * dob.hashCode();
    }

    public int hashCode(String name, String address, String email, LocalDate dob) {
        return (int) name.hashCode() * address.hashCode() * email.hashCode() * dob.hashCode();
    }
}