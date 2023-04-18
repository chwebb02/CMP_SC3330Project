package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class DVD extends LibraryCollection {
    public DVD(char[] ISSN, SectionCode section, float cost) throws InvalidIdentifierSizeException {
        super(ISSN, section, cost);
    }

    public char[] getDOI() {
        return identifier;
    }
}
