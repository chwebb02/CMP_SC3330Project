package Utils;

import java.time.LocalDate;

import Collections.LibraryCollection;

// This class is a container for a Library Collection object that has been checked out
// It contains the media, the checkout date, and the due date
public class CheckedOutMedia {
    private LibraryCollection checkedOutMedia;      // The actual object that was checked out
    private LocalDate checkOutDate;                // The date the media was checked out
    private LocalDate TwelveDate;
    private LocalDate monthEndDate;
    private LocalDate dueDate;// The date that the media is due
    private boolean lost;
    private LocalDate currDate;
    private boolean fullCharge;

    public CheckedOutMedia(LibraryCollection media) {
        checkedOutMedia = media;
        checkOutDate = LocalDate.now();
        currDate = LocalDate.now();
        lost = false;
        fullCharge = false;
        TwelveDate = checkOutDate.plusDays(12);
        dueDate = checkOutDate.plusDays(14);
        monthEndDate = checkOutDate.plusDays(28);
    }

    // public void counterDate()
    // {
    //     currDate.plusDays(1);
    // }

    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public boolean Warning()
    {
        LocalDate date = getCurrentDate();
        if(date.isEqual(dueDate))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean dueDateCheck()
    {
        LocalDate date = getCurrentDate();
        if(date.isEqual(dueDate))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean LetterWarning()
    {
        LocalDate date = getCurrentDate();
        if(date.isEqual(monthEndDate))
        {
            lost = true;
            fullCharge = true;
            return true;
        }
        else
        {
            return false;
        }
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
