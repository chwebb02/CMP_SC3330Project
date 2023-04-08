package Collections;

import CustomExceptions.InvalidIdentifierSizeException;
import java.util.HashMap;

public class DVD extends LibraryCollection {
    // In memory storage of all of the DVDs in the collection
    public static HashMap<char[], DVD> dvdCollection = new HashMap<char[], DVD>();

    DVD(char[] DOI, byte section) throws InvalidIdentifierSizeException {
        super(DOI, section);
    }

    public char[] getDOI() {
        return identifier;
    }

    public int DVDCount() {
        return dvdCollection.size();
    }
}
