package Collections;

import java.util.UUID;

/*
LibraryCollection:
The abstract class that all pieces of media inherit from
Basic information relating to their accessibility, location, and identifiers are avaiable here
*/
abstract class LibraryCollection {
    public static long collectionSize = 0;

    private UUID identifier;
    private String section;
    private boolean isCheckedOut = false;

    LibraryCollection(UUID id, String section) {
        identifier = id;
        this.section = section;

        collectionSize += 1;
    }
}
