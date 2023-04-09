package People;

import java.time.LocalDate;

import Utils.SSN;

public class Member extends Person {
    int UID;

    //! Requires a default constructor as Person is inherited, but don't know what to include in it
    public Member() {
    }

    public Member(String name, String address, String email, LocalDate dob, SSN ssn) {
        super(name, address, email, dob, ssn);
        UID = hashCode(name, address, email, dob);
    }

    @Override
    public int hashCode() {
        return (int) name.hashCode() * address.hashCode() * email.hashCode() * dob.hashCode();
    }

    public int hashCode(String name, String address, String email, LocalDate dob) {
        return (int) name.hashCode() * address.hashCode() * email.hashCode() * dob.hashCode();
    }
}
