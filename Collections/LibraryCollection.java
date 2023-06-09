package Collections;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import Utils.CheckedOutMedia;
import People.Member;

import CustomExceptions.InvalidIdentifierSizeException;

/*
LibraryCollection:
The abstract class that all pieces of media inherit from
Basic information relating to their accessibility, location, and identifiers are avaiable here
*/
public abstract class LibraryCollection {
    public static enum SectionCode {
        ARTS,
        SCIENCES,
        NEWSPAPER,
        LAW,
    };

    // Hashmap to store all members of the collection, because databases are cringe
    private static HashMap<String, LibraryCollection> collection = new HashMap<>();
    private static HashMap<String, CheckedOutMedia> checkedOut = new HashMap<>();

    protected char[] identifier;                // The ISBN or ISSN of a book
    private SectionCode section;                // The numeric code corresponding to the section the media belongs to
    private boolean isCheckedOut = false;       // Is the piece of media already checked out?
    private float cost;

    // No default constructor, too much headache
    protected LibraryCollection(char[] id, SectionCode section, float cost) throws InvalidIdentifierSizeException {
        if (id.length != 6) {
            throw new InvalidIdentifierSizeException("The size of the input was " + id.length + ", when it needed to be of size 6");
        } else {
            identifier = id;
            this.section = section;
            this.cost = cost;
            collection.put(new String(id), this);
        }
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public static void printCollection() {
        System.out.println(collection);
    }

    // ! TODO ADD A WAY TO GET THE PERSON CHECKING OUT
    public static void checkOverdues() {
        for (HashMap.Entry<String, CheckedOutMedia> set : checkedOut.entrySet()) {
            CheckedOutMedia com = set.getValue();
            if (com.Warning())
                System.out.println("Email to " + com.getOwner().getEmail() + ": Just a reminder "
                        + com.getOwner().getName() + ", " + set.getKey() + " is due in 2 days");
            if (com.dueDateCheck())
                System.out.println("Email to " + com.getOwner().getEmail() + ": Just a reminder "
                        + com.getOwner().getName() + ", " + set.getKey() + " is due today");
            if (com.LetterWarning()) {
                System.out.println("Letter to " + com.getOwner().getAddress() + ": Just a reminder "
                        + com.getOwner().getName() + ", " + set.getKey() + " is due today");
                System.out.println("Email to " + com.getOwner().getEmail() + ": Just a reminder "
                        + com.getOwner().getName() + ", " + set.getKey() + " is due today");
            }
            
            com.isLate();
            com.setLastChecked();
        }
    }

    public static LinkedList<CheckedOutMedia> getOverdueList() {
        LinkedList<CheckedOutMedia> out = new LinkedList<CheckedOutMedia>();
        for (CheckedOutMedia com : checkedOut.values()) {
            if (com.isLate()) {
                out.add(com);
            }
        }

        return out;
    }

    public static boolean save() {
        try {
            String fileName = "../Data/collection.txt";
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (LibraryCollection obj : collection.values()) {
                oos.writeObject(obj);
            }

            oos.close();
            fos.close();
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    // Load all objects into the hashmaps
    public static boolean load() {
        try {
            String fileName = "../Data/collection.txt";
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            LibraryCollection obj;
            do {
                obj = (LibraryCollection) ois.readObject();
                collection.put(obj.identifier.toString(), obj);
            } while (obj != null);

            ois.close();
            fis.close();

        } catch (IOException e) {
            return false;
        } catch (ClassNotFoundException f) {
            return false;
        }

        return true;
    }

    // Return value for getISBN or getISSN on subclasses
    public char[] getID() {
        return identifier;
    }

    // Returns the numeric representation of the section
    public SectionCode getSection() {
        return section;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    // Attempts to check out a book, if it is already checked out, return false
    // otherwise return true
    // Calling function will have to ensure other conditions (such as available
    // slots for member)
    public boolean checkOut(Member mem) {
        return checkOut(mem, LocalDate.now());
    }

    public boolean checkOut(Member mem, LocalDate date) {
        if (isCheckedOut) {
            return false;
        }

        CheckedOutMedia item = new CheckedOutMedia(this, mem, date);
        checkedOut.put(new String(this.identifier), item);

        isCheckedOut = true;
        return true;
    }

    // Returns a book to the library, thus setting checkedOut status to false
    public void returnToCollection() {
        checkedOut.remove(this.identifier);
        isCheckedOut = false;
    }

    // Returns the size of the library collection
    public static int getCollectionSize() {
        return collection.size();
    }

    public static LibraryCollection getMedia(String id) {
        return collection.get(id);
    }

    public static CheckedOutMedia getCheckedOut(String id) {
        return checkedOut.get(id);
    }

    public static boolean removeFromCollection(String id) {
        if (collection.remove(id) != null)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "LibraryCollection [identifier=" + Arrays.toString(identifier) + ", section=" + section
                + ", isCheckedOut=" + isCheckedOut + "]";
    }
}
