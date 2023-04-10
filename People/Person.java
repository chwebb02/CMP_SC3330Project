package People;

import Utils.SSN;
import java.time.LocalDate;

/*
Person:
The abstract class that all people inherit from
Basic information relating to their name, address, email, password, dob, and ssn are avaiable here
*/
abstract class Person {
    // Instance Variables
    String name, address, email, password;

    LocalDate dob;
    SSN ssn;

    Person(String name, String address, String email, String password, LocalDate dob, SSN ssn) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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