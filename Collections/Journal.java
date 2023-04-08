package Collections;

import CustomExceptions.InvalidIdentifierSizeException;
import java.util.HashMap;

public class Journal extends LibraryCollection {
    // In memory storage of all of the journals in the collection
    public static HashMap<char[], Journal> journalCollection = new HashMap<char[], Journal>();

    Journal(char[] ISSN, byte section) throws InvalidIdentifierSizeException {
        super(ISSN, section);
    }

    public char[] getISSN() {
        return identifier;
    }

    public int journalCount() {
        return journalCollection.size();
    }
}
