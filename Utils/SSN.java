package Utils;

import java.util.*;
import CustomExceptions.*;

public class SSN {
    private int ssn;
   public SSN(int incoming)
    {   

       // if(String.valueOf(incoming).length() == 9)
      //  {
            this.ssn=incoming;
       // }
        //else{System.out.println("Wrong size");}
    }
  public  SSN(SSN incoming)
    {
        this.ssn=incoming.ssn;
    }

    public void setSSN(int incoming)
    {
        this.ssn=incoming;
    }
    public void setSSN(SSN incoming)
    {
        this.ssn=incoming.ssn;
    }
    public SSN getSSN()
    {
        return this;
    }
    public int getIntSSN()
    {
        return this.ssn;
    }




}
