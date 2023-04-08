package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class Journal extends LibraryCollection{
    Journal(char[] ISSN, byte section) throws InvalidIdentifierSizeException {
        super(ISSN, section);
    }

    public char[] getISSN() {
        return identifier;
    }
}
