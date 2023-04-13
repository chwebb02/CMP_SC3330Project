package Collections;

import CustomExceptions.InvalidIdentifierSizeException;
import java.util.HashMap;

public class Newspaper extends LibraryCollection {
    // In memory storage of all of the newspapers in the collection
    public static HashMap<char[], Newspaper> newspaperCollection = new HashMap<char[], Newspaper>();

    public Newspaper(char[] ISSN, byte section) throws InvalidIdentifierSizeException {
        super(ISSN, LibraryCollection.SectionCode.NEWSPAPER);
        newspaperCollection.put(identifier, this);
    }

    public char[] getISSN() {
        return identifier;
    }

    public int newspaperCount() {
        return newspaperCollection.size();
    }
}
