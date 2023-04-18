package People;

import Utils.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Stack;

import Collections.LibraryCollection;

public class Technician extends Employee {
    private static Stack<LibraryCollection> toBeReshelved;

    public Technician(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }

    public Technician(Object emp) {
        super(emp);
    }

    public static void addToShelveQueue(LibraryCollection item) {
        toBeReshelved.push(item);
    }

    public static void removeFromShelveQueue(LibraryCollection item) {
        toBeReshelved.pop().returnToCollection();
    }

    public static void recieveMedia(LibraryCollection media) {
        addToShelveQueue(media);
    }

}
