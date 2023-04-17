package People;

import Utils.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Stack;

import Collections.*;


 
 abstract public class Technician extends Employee {
  static private Stack<Collections.LibraryCollection> TBR;


    static public void pushTBR(Collections.LibraryCollection item)
    {
        TBR.push(item);
    }

    static public void pullTBR()
    {
        TBR.pop().returnToCollection();
    }

    Technician(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }





}
