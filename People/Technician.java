package People;

import Utils.*;
import java.time.LocalDate;
import java.util.Stack;

import Collections.LibraryCollection;


 
 public class Technician extends Employee {
   private static Stack<LibraryCollection> toBeReshelved;

    Technician(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }

    public static void addToShelveQueue(LibraryCollection item)
    {
        toBeReshelved.push(item);
    }

    public static void removeFromShelveQueue(LibraryCollection item)
    {
        toBeReshelved.pop().returnToCollection();
    }

    public static void recieveMedia(LibraryCollection media) {
        addToShelveQueue(media);
    }

    public void menu() {
        // TODO
    }
}
