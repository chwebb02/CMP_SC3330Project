package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class DVD extends LibraryCollection {
    public DVD(char[] ISBN, SectionCode section, float cost) throws InvalidIdentifierSizeException {
        super(ISBN, section, cost);
    }

    public char[] getDOI() {
        return identifier;
    }
}
