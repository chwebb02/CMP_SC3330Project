package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class DVD extends LibraryCollection {
    DVD(char[] DOI, byte section) throws InvalidIdentifierSizeException {
        super(DOI, section);
    }

    public char[] getDOI() {
        return identifier;
    }
}
