package Collections;

import CustomExceptions.InvalidIdentifierSizeException;
import java.util.HashMap;

public class Book extends LibraryCollection {
    // In memory storage of all books in the collection
    public static HashMap<char[], Book> bookCollection = new HashMap<char[], Book>();

    public Book(char[] ISBN, SectionCode section) throws InvalidIdentifierSizeException {
        super(ISBN, section);
        bookCollection.put(identifier, this);
    }

    public char[] getISBN() {
        return identifier;
    }

    public int bookCount() {
        return bookCollection.size();
    }
}
