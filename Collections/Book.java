package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class Book extends LibraryCollection {
    public Book(char[] ISBN, SectionCode section, float cost) throws InvalidIdentifierSizeException {
        super(ISBN, section, cost);
    }

    public char[] getISBN() {
        return identifier;
    }
}
