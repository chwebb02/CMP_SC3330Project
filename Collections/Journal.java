package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class Journal extends LibraryCollection {
    public Journal(char[] ISSN, SectionCode section) throws InvalidIdentifierSizeException {
        super(ISSN, section);
    }

    public char[] getISSN() {
        return identifier;
    }
}
