package LibraryEvents;

import java.util.Scanner;

import People.Member;
//import People.*;
import Utils.Email;
import Utils.SSN;
import Utils.Login;
import java.time.LocalDate;
import java.time.Month;

public class newMember {


    public  String name; 
    public  String address;
    public  Login login;
    public  String tempUname,tempPass;
    public  Email email;
    public  LocalDate dob;
    public  SSN ssn;

   public   newMember()
   {
    name=null;
    login=null;
    address=null;
    tempPass=null;
    tempUname=null;
    dob=null;
    ssn=null;
   }
   public newMember setnMember()
   {


    Scanner input=new Scanner(System.in);
    String resp="no";
    System.out.println("Thank you so much for becoming a member, please enter the following information below to complete your signup");
    for(char i='c';i=='c';)//name
    {
        System.out.printf("Please Enter your name\n>");
        resp=input.nextLine();
        if(true    /*add name validation here later */)
        {
           this.name=resp;
            i='b';
        }
        else{System.out.printf("Im sorry but \"%s\" is not a valid name, please try again\n",resp); i='c';}
    }
    for(char i='c';i=='c';)//address
    {
        System.out.printf("Please Enter your Address\n>");
        resp=input.nextLine();
        if(true   /*add Address validation here later */)
        {
            this.address=resp;
            i='b';
        }
        else{System.out.printf("Im sorry but \"%s\" is not a valid Address, please try again\n",resp); i='c';}
    }
    for(char i='c';i=='c';)//login
    {
        System.out.printf("Please Enter a login\n>");
        resp=input.nextLine();
        if(true   /*add login validation here later */)
        {
            this.tempUname=resp;
            i='b';
        }

        else{System.out.printf("Im sorry but \"%s\" is not a valid login, please try again\n",resp); i='c';}
    } 
    for(char i='c';i=='c';)//password
    {
        System.out.printf("Please Enter a password\n>");
        resp=input.nextLine();
        if(true   /*add password validation here later */)
        {
            this.tempPass=resp;
            i='b';
        }

        else{System.out.printf("Im sorry but \"%s\" is not a valid password, please try again\n",resp); i='c';}
    } 
    
    
    for(char i='c';i=='c';)//email
    {
        
        System.out.printf("Please Enter an email address\n>");
        resp=input.nextLine();
        if(true   /*add email validation here later */)
        {
           this.email=new Email(resp);
           i='b';
        }

        else{System.out.printf("Im sorry but \"%s\" is not a valid email address, please try again\n",resp); i='c';}
    }
    for(char i='c';i=='c';)//dob
    {
        System.out.printf("Please Enter a date of birth in a mm/dd/yy formatt seperated by a /\n>");
        resp=input.nextLine();
        
        if(true   /*add dob validation here later */)
        {

            String[] temp=new String[3];
            temp=resp.split("/");

            this.dob= LocalDate.of(0,5,4);
            i='b';
        }

        else{System.out.printf("Im sorry but \"%s\" is not a valid date of birth, please try again\n",resp); i='c';}
   
    }
    for(char i='c';i=='c';)//ssn
    {
        System.out.printf("Please Enter a valid SSN\n>");
        resp=input.nextLine();
        
        if(true   /*add SSN validation here later */)
        {
           this.ssn=new SSN(Integer.parseInt(resp));
           i='b';
        }

        else{System.out.printf("Im sorry but \"%s\" is not a valid SSN, please try again\n",resp); i='c';}
     
    }
    login=new Login(tempUname,tempPass);
// public Member(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
       


        return this;
    }
    public String getName()
    {
        return this.name;
    }
    public String getAddress()
    {
        return this.address;
    }
    public Login getLogin()
    {
        return this.login;
    }
    public LocalDate getDob()
    {
        return this.dob;
    }
    public SSN getSSN()
    {
        return this.ssn;
    }
    public Email getEmail()
    {
      return this.email;  
    }
public static void main(String[] args) {
    

   /* LocalDate x=LocalDate.of(1, Month.APRIL, 12);
    System.out.printf("X has %d year %s month and %d day",x.getYear(),x.getMonthValue(),x.getDayOfMonth());


   newMember nMember= new newMember();
   nMember.setmMember();*/
}
}
