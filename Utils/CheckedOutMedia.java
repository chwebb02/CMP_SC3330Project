package Utils;

import java.time.LocalDate;

import Collections.LibraryCollection;
import People.Member;

// This class is a container for a Library Collection object that has been checked out
// It contains the media, the checkout date, and the due date
public class CheckedOutMedia {
    private LibraryCollection checkedOutMedia;      // The actual object that was checked out
    private LocalDate checkOutDate;                // The date the media was checked out
    private LocalDate TwelveDate;
    private LocalDate monthEndDate;
    private LocalDate dueDate;// The date that the media is due
    private boolean lost;
    private LocalDate lastChecked;
    private boolean fullCharge;
    private Member owner;      // Who checked it out

    public CheckedOutMedia(LibraryCollection media, Member mem) {
        checkedOutMedia = media;
        checkOutDate = LocalDate.now();
        // currDate = LocalDate.now();
        lost = false;
        fullCharge = false;
        TwelveDate = checkOutDate.plusDays(12);
        dueDate = checkOutDate.plusDays(14);
        monthEndDate = checkOutDate.plusDays(28);
        owner = mem;
    }

    public Member getOwner() {
        return owner;
    }

    // public void counterDate()
    // {
    //     currDate.plusDays(1);
    // }

    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public boolean renew() {
        if (isLate()) return false;
        TwelveDate = getCurrentDate().plusDays(12);
        dueDate = getCurrentDate().plusDays(14);
        monthEndDate = getCurrentDate().plusDays(28);
        return true;
    }

    public void setLastChecked() {
        lastChecked = getCurrentDate();
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
            if (getCurrentDate() != lastChecked) {
                owner.addFee(checkedOutMedia.getCost());
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isLate(LocalDate date) {
        if (date.isAfter(dueDate)) {
            if (getCurrentDate() != lastChecked) {
                owner.addFee(1f);
            }
            return true;
        }

        return false;
    }

    public boolean isLate() {
        return isLate(LocalDate.now());
    }



}
