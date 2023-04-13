package People;

import Utils.*;
import java.time.LocalDate;
import java.util.HashMap;

/*
Person:
The abstract class that all people inherit from
Basic information relating to their name, address, email, password, dob, and ssn are avaiable here
*/
public abstract class Person {
    private static HashMap<String, Person> peopleDB = new HashMap<String, Person>();

    // Instance Variables
    private String name, address;

    private Login login;
    private Email email;
    private LocalDate dob;
    private SSN ssn;

    protected boolean entryGranted = false;         // If a login is successful, this will be set to true
                                                    // Use this in subclasses for permission checking

    Person(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.login = login;
        this.dob = dob;
        this.ssn = ssn;

        peopleDB.put(name, this);
    }

    // Tries to login, returns true or false to indicate whether it was successful
    public static boolean login(Login attempt) {
        Person target = peopleDB.get(attempt.getUsername());

        target.entryGranted = target.login.verify(attempt);
        return target.entryGranted;
    }

    // Logs out a user
    public void logout() {
        entryGranted = false;
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
    public Email getEmail() {
        return email;
    }
    public void setEmail(Email email) {
        this.email = email;
    }
    public Login getLogin() {
        return login;
    }
    public void setLogin(Login login) {
        this.login = login;
    }
    
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

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