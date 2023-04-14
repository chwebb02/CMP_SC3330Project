package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class DVD extends LibraryCollection {
    public DVD(char[] DOI, SectionCode section) throws InvalidIdentifierSizeException {
        super(DOI, section);
    }

    public char[] getDOI() {
        return identifier;
    }
}
