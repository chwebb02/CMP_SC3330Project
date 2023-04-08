package Collections;

import CustomExceptions.InvalidIdentifierSizeException;

public class Book extends LibraryCollection {
    Book(char[] ISBN, byte section) throws InvalidIdentifierSizeException {
        super(ISBN, section);
    }

    public char[] getISBN() {
        return identifier;
    }
}
