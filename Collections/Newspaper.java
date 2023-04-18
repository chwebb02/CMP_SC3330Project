package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class Newspaper extends LibraryCollection {
    public Newspaper(char[] ISSN, SectionCode section, float cost) throws InvalidIdentifierSizeException {
        super(ISSN, section, cost);
    }

    public char[] getISSN() {
        return identifier;
    }
}
