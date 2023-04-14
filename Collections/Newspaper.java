package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class Newspaper extends LibraryCollection {
    public Newspaper(char[] ISSN, SectionCode section) throws InvalidIdentifierSizeException {
        super(ISSN, section);
    }

    public char[] getISSN() {
        return identifier;
    }
}
