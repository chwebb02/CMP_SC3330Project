package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class Newspaper extends LibraryCollection {
    Newspaper(char[] ISSN, byte section) throws InvalidIdentifierSizeException {
        super(ISSN, section);
    }

    public char[] getISSN() {
        return identifier;
    }
}
