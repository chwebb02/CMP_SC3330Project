package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class Book extends LibraryCollection {
    public Book(char[] ISBN, SectionCode section) throws InvalidIdentifierSizeException {
        super(ISBN, section);
    }

    public char[] getISBN() {
        return identifier;
    }
}
