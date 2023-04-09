package People;

import java.time.LocalDate;
import Utils.SSN;

abstract class Person {
    // Instance Variables
    String name, address, email;
    LocalDate dob;
    SSN ssn;

    //! Requires a default constructor as Person is inherited, but don't know what to include in it
    protected Person() {
    }

    protected Person(String name, String address, String email, LocalDate dob, SSN ssn) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.dob = dob;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    // ToDo: Update with proper SSN implementation
    public SSN getSsn() {
        return ssn;
    }
    public void setSsn(SSN ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", address=" + address + ", email=" + email + ", dob=" + dob + ", ssn=" + ssn
                + "]";
    }
}