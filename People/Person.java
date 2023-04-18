package People;

import Utils.*;
import java.time.LocalDate;
import java.util.HashMap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Person:
The abstract class that all people inherit from
Basic information relating to their name, address, email, password, dob, and ssn are avaiable here
*/
public abstract class Person implements Serializable {
    private static HashMap<String, Person> peopleDB = new HashMap<String, Person>();

    // Instance Variables
    private String name, address;

    private Login login;
    private Email email;
    private LocalDate dob;
    private SSN ssn;

    protected boolean entryGranted = false; // If a login is successful, this will be set to true
                                            // Use this in subclasses for permission checking

    Person(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        if (peopleDB.containsKey(name))
            return;

        this.name = name;
        this.address = address;
        this.email = email;
        this.login = login;
        this.dob = dob;
        this.ssn = ssn;

        peopleDB.put(name, this);
    }

    Person(Object ps) {
        Person p = (Person) ps;
        this.name = p.name;
        this.address = p.address;
        this.email = p.email;
        this.login = p.login;
        this.dob = p.dob;
        this.ssn = p.ssn;

        peopleDB.put(p.name, this);
    }

    public static void test() {
        for (String key : peopleDB.keySet()) {
            System.out.println(key);
            System.out.println(peopleDB.get(key).toString());
        }
    }

    // Tries to login, returns true or false to indicate whether it was successful
    public static boolean login(Login attempt) {
        Person target = peopleDB.get(attempt.getUsername());

        target.entryGranted = target.login.verify(attempt);
        return target.entryGranted;
    }

    public static Person getPerson(String name) {
        return peopleDB.get(name);
    }

    public static boolean removePerson(String name) {
        if (peopleDB.remove(name) != null)
            return true;
        else
            return false;
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

    public void saveTo(String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object loadFrom(String fileName) {
        Object person = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            person = (Object) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

}