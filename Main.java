import People.*;
import Utils.Login;

import java.lang.WeakPairMap.Pair.Lookup;
import java.util.Scanner;

import Collections.*;

public class Main {
    public static void main(String[] args) {
        
    
    Scanner input=new Scanner(System.in);

    String resp= new String("Continue");
   
    while(!resp.equals("quit"))
    {
        System.out.println("Hello, and welcome to the Library, what can we do for you today?\n~Type B to Become A member~\n~Quit~\n>");
        resp=input.nextLine();
        resp=resp.toLowerCase();
        switch (resp) {
            case "checkout" :
            String tempname;
            String temppassword;
            System.out.printf("Please log into your library account\nWhat is your username?\n>");
            tempname=input.nextLine();
            System.out.printf("What is your Password?\n>");
            temppassword=input.nextLine();
            Scanner authsScanner=new Scanner(System.in);
            String auString="yes";
            while(auString.equals("yes") )
            {

                if(Person.login(new Login(tempname, temppassword)))
                {
                    System.out.print("What book would you like to check out? (Please type its 6 digit ISBN/ISSN/DOI number\n>)");
                    
                    (LibraryCollection.lookupMedia(resp.toCharArray())).checkOut();
                    System.out.printf("Thank you for checking out %s, you will now have (forgot how long :/) days to either return or extend your checkout\nWould you like to checkout anything else? [yes/no]",resp);
                    auString=authsScanner.nextLine();
                    
                }
                else
                {
                    System.out.println("It seems that login isnt correct, would you like yo try again [yes/no]");
                    auString=authsScanner.nextLine();
                }

            }

                break;
            case "b" :
                Librarian.newMemberEvent();
                break;
        
            case "quit" :
               System.out.println("Thank you for Visiting the library, come back soon :D"); 
               
                break;
        
            default:
                System.out.printf("Im sorry, \" %s \" is not a valid option please check your spelling and try again or type Quit to quit",resp);
                break;
        }



    }

















    }
}
