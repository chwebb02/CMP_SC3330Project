package People;

import Utils.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Stack;

import Collections.*;


 
 public class Technician extends Employee {
   private Stack<Collections.LibraryCollection> TBR;


    public void pushTBR(Collections.LibraryCollection item)
    {
        TBR.push(item);
    }

    public void pullTBR()
    {
        TBR.pop().returnToCollection();
    }

    Technician(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }





}
