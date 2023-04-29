package People;

import Utils.*;
import java.time.LocalDate;
import java.util.ArrayList;

import Collections.LibraryCollection;

public class Technician extends Employee {
    private static ArrayList<LibraryCollection> toBeReshelved = new ArrayList<>();

    public Technician(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }

    public Technician(Object emp) {
        super(emp);
    }

    public static void addToShelveQueue(LibraryCollection item) {
        toBeReshelved.add(item);
    }

    public static boolean removeFromShelveQueue(LibraryCollection item) {
        if (!toBeReshelved.remove(item))
            return false;
        item.returnToCollection();
        return true;
    }

    public static void recieveMedia(LibraryCollection media) {
        addToShelveQueue(media);
    }

}
