package People;

import Utils.*;
import java.time.LocalDate;
import Collections.*;

public class Technician extends Employee {
    Technician(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }
    
    public static void  reShelveItem(Collections.LibraryCollection item ){ //takes an item to be reshelved, if the item is checked out, it is changed to be avaliable
        //if for some reason it is avaliable, nothing happens
        if( !item.checkOut())
        {
            item.returnToCollection();
        }
        else{System.out.println("This item is already reshelved");}
    }



}
