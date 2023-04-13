package People;

import Utils.*;
import java.time.LocalDate;
import java.util.Queue;
import java.util.Scanner;
import Collections.*;

public class Librarian extends Employee{
    Librarian(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }
    Queue <String> returned;
    
    public void assistance()
    {
        Scanner input=new Scanner(System.in);
        String resp;

        System.out.println("Hello, welcome to the Library, what can I help you with?\n>Membership\n>Checkout an item\n>Quit");//More to be added
        resp=input.nextLine();
            input.nextLine();
        while(!resp.contains("Quit"))   
        {
            switch (resp) {
                case "Membership":
                    System.out.println("You are inside the Membership case");
                    break;
            
                default:
                    System.out.println("Im sorry, that isnt a valid option, please check your spelling and try again");
                    break;
                case"return":
                System.out.println("Please enter the item that you are returning");
                returnItem(input.nextLine());
                break;
            }
        }
        System.out.println("Thank you for using the libray, come back soon :)");
        input.close();
    }
    private void returnItem(String item)
    {
        returned.add(item);
    }
}
