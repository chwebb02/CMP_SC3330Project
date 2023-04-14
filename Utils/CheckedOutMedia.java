package Utils;

import java.time.LocalDate;

import Collections.LibraryCollection;

// This class is a container for a LibrarCollection object that has been checked out
// It contains the media, the checkout date, and the due date
public class CheckedOutMedia {
    private LibraryCollection mediaItem;      // The actual object that was checked out
    private LocalDate checkOutDate;                 // The date the media was checked out
    private LocalDate dueDate;                      // The date that the media is due

    public CheckedOutMedia(LibraryCollection media) {
        mediaItem = media;
        checkOutDate = LocalDate.now();
        dueDate = checkOutDate.plusDays(14);
    }

    public boolean isLate(LocalDate date) {
        if (date.isAfter(dueDate)) {
            return true;
        }

        return false;
    }

    public boolean isLate() {
        return isLate(LocalDate.now());
    }


}
