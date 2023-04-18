package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class Journal extends LibraryCollection {
    public Journal(char[] ISSN, SectionCode section, float cost) throws InvalidIdentifierSizeException {
        super(ISSN, section, cost);
    }

    public char[] getISSN() {
        return identifier;
    }
}
