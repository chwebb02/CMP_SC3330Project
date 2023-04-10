package Collections;

import java.util.HashMap;
import CustomExceptions.InvalidIdentifierSizeException;

/*
LibraryCollection:
The abstract class that all pieces of media inherit from
Basic information relating to their accessibility, location, and identifiers are avaiable here
*/
public abstract class LibraryCollection {
    // Hashmap to store all members of the collection, because databases are cringe
    public static HashMap<char[], LibraryCollection> collection = new HashMap<char[], LibraryCollection>();

    protected char[] identifier;                // The ISBN or ISSN of a book
    private byte section;                       // The numeric code corresponding to the section the media belongs to
    private boolean isCheckedOut = false;       // Is the piece of media already checked out?

    // No default constructor, too much headache
    LibraryCollection(char[] id, byte section) throws InvalidIdentifierSizeException{
        if (id.length != 6) {
            throw new InvalidIdentifierSizeException("The size of the input was " + id.length + ", when it needed to be of size 6");
        } else {
            identifier = id;
            this.section = section;
            collection.put(id, this);
        }        
    }

    // Return value for getISBN or getISSN on subclasses
    public char[] getID() {
        return identifier;
    }

    // Returns the numeric representation of the section 
    public byte getSection() {
        return section;
    }

    // Attempts to check out a book, if it is already checked out, return false
    // otherwise return true
    // Calling function will have to ensure other conditions (such as available slots for member)
    public boolean checkOut() {
        if(isCheckedOut) {
            return false;
        }

        return true;
    }

    // Returns a book to the library, thus setting checkedOut status to false
    public void returnToCollection() {
        isCheckedOut = false;
    }

    // Returns the size of the library collection
    public static int getCollectionSize() {
        return collection.size();
    }
}
