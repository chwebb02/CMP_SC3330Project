package Collections;

import CustomExceptions.InvalidIdentifierSizeException;
import java.util.HashMap;

public class Journal extends LibraryCollection {
    // In memory storage of all of the journals in the collection
    public static HashMap<char[], Journal> journalCollection = new HashMap<char[], Journal>();

    public Journal(char[] ISSN, SectionCode section) throws InvalidIdentifierSizeException {
        super(ISSN, section);
        journalCollection.put(identifier, this);
    }

    public char[] getISSN() {
        return identifier;
    }

    public int journalCount() {
        return journalCollection.size();
    }
}
