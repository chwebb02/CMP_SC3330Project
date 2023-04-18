package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class Book extends LibraryCollection {
    public Book(char[] ISSN, SectionCode section, float cost) throws InvalidIdentifierSizeException {
        super(ISSN, section, cost);
    }

    public char[] getISBN() {
        return identifier;
    }
}
