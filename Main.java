import People.*;
import Utils.*;
import Collections.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.time.LocalDate;

class Main {

    public static void mainMenu() {
        System.out.println("University of Java Library System");
        System.out.println("Menu Options");
        System.out.println("10. Print Members");
        System.out.println("20. Print Books");
        System.out.println("1. New Membership");
        System.out.println("11. Load Membership from File");
        System.out.println("2. New Collection");
        System.out.println("3. Remove Membership");
        System.out.println("4. Remove Item from Collection");
        System.out.println("5. New Employee");
        System.out.println("51. Load Employee from File");
        System.out.println("6. Borrow Item");
        System.out.println("7. Return Item");
        System.out.println("8. Check overdues");
        System.out.println("9. Quit");
        System.out.println("");
    }

    // You can either implement your events in these functions, or you can write an
    // Event class and call a static function here.
    public static void newMemberEvent() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Membership info: ");

        System.out.print("Enter Member Name: ");
        String name = scn.nextLine();
        System.out.print("Enter Member Address: ");
        String address = scn.nextLine();

        System.out.print("Enter Member email: ");
        String emailString = scn.nextLine();
        Email email = new Email(emailString);

        System.out.print("Enter Login Name: ");
        String username = scn.nextLine();
        System.out.print("Enter Password: ");
        String pwd = scn.nextLine();
        Login login = new Login(username, pwd);

        System.out.print("Enter Member Date of Birth (YYYY-MM-DD): ");
        String dobString = scn.nextLine();
        LocalDate dob = LocalDate.parse(dobString);

        System.out.print("Enter Member SSN: ");
        String ssnString = scn.nextLine();
        SSN ssn = new SSN(ssnString);

        System.out.print("Enter Membership type (Student/Professor/External): ");
        String memtype = scn.nextLine();
        System.out.print("Creating a new member...");

        Member mem;
        switch (memtype) {
            case ("Student"):
                mem = (Member) new Student(name, address, email, login, dob, ssn);
                break;
            case ("Professor"):
                mem = (Member) new Professor(name, address, email, login, dob, ssn);
                break;
            case ("External"):
                mem = (Member) new External(name, address, email, login, dob, ssn);
                break;
            default:
                return;
        }

        System.out.println("The membership ID is: " + mem.getUUID());
        System.out.println(mem.toString());

        // Save the new member into the membership database
        mem.saveTo("membershipdatabasefile.txt");
        System.out.println("New Member Successfully Saved to file.");
    }

    public static void loadMemberEvent() {
        System.out.println("Loading member from file");
        Member mem = (Member) Person.loadFrom("membershipdatabasefile.txt");
        if (mem instanceof Student)
            new Student(mem);
        if (mem instanceof Professor)
            new Professor(mem);
        if (mem instanceof External)
            new External(mem);
        System.out.println("Loaded");
        System.out.println(mem.toString());
    }

    public static void newCollectionEvent() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Media info: ");

        System.out.print("Enter Media Section (Arts/Sciences/Newspaper/Law): ");
        String sectionString = scn.nextLine();
        LibraryCollection.SectionCode section;
        switch (sectionString) {
            case ("Arts"):
                section = LibraryCollection.SectionCode.ARTS;
                break;
            case ("Sciences"):
                section = LibraryCollection.SectionCode.SCIENCES;
                break;
            case ("Newspaper"):
                section = LibraryCollection.SectionCode.NEWSPAPER;
                break;
            case ("Law"):
                section = LibraryCollection.SectionCode.LAW;
                break;
            default:
                return;
        }

        System.out.print("Enter ISBN: ");
        char[] id = scn.nextLine().toCharArray();

        System.out.print("Enter Media Type (Book/DVD/Journal/Newspaper): ");
        String type = scn.nextLine();

        System.out.print("Enter Price: ");
        Float price = scn.nextFloat();

        LibraryCollection media;
        try {
            switch (type) {
                case ("Book"):
                    media = new Book(id, section, price);
                    break;
                case ("DVD"):
                    media = new DVD(id, section, price);
                    break;
                case ("Journal"):
                    media = new Journal(id, section, price);
                    break;
                case ("Newspaper"):
                    media = new Newspaper(id, section, price);
                    break;
                default:
                    return;
            }
        } catch (Exception e) {
            return;
        }

        System.out.println("Creating a new member...");
        System.out.println(media.toString());
    }

    public static void newRemoveMemberEvent() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Person's name to remove: ");
        String name = scn.nextLine();

        System.out.println("Removing " + name + "...");
        Person.removePerson(name);
        System.out.println("Removed " + name);
    };

    public static void newRemoveCollectionEvent() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Media's ISSN/ISBN to remove: ");
        String id = scn.nextLine();

        System.out.println("Removing " + id + "...");
        LibraryCollection.removeFromCollection(id);
        System.out.println("Removed " + id);
    };

    public static void newEmployeeEvent() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Employee info: ");

        System.out.print("Enter Employee Name: ");
        String name = scn.nextLine();
        System.out.print("Enter Employee Address: ");
        String address = scn.nextLine();

        System.out.print("Enter Employee email: ");
        String emailString = scn.nextLine();
        Email email = new Email(emailString);

        System.out.print("Enter Login Name: ");
        String username = scn.nextLine();
        System.out.print("Enter Password: ");
        String pwd = scn.nextLine();
        Login login = new Login(username, pwd);

        System.out.print("Enter Employee Date of Birth (YYYY-MM-DD): ");
        String dobString = scn.nextLine();
        LocalDate dob = LocalDate.parse(dobString);

        System.out.print("Enter Employee SSN: ");
        String ssnString = scn.nextLine();
        SSN ssn = new SSN(ssnString);

        System.out.print("Enter Employee type (Librarian/Technician): ");
        String emptype = scn.nextLine();
        System.out.print("Creating a new employee...");

        Employee emp;
        switch (emptype) {
            case ("Librarian"):
                emp = new Librarian(name, address, email, login, dob, ssn);
                break;
            case ("Technician"):
                emp = new Technician(name, address, email, login, dob, ssn);
                break;
            default:
                return;
        }

        System.out.println("The employee name is: " + emp.getName());
        System.out.println(emp.toString());

        // Save the new member into the membership database
        emp.saveTo("employeedatabasefile.txt");
        System.out.println("New Employee Successfully Saved to file.");
    };

    public static void loadEmployeeEvent() {
        System.out.println("Loading employee from file");
        Employee emp = (Employee) Person.loadFrom("employeedatabasefile.txt");
        if (emp instanceof Librarian)
            new Librarian(emp);
        if (emp instanceof Technician)
            new Technician(emp);
        System.out.println("Loaded");
        System.out.println(emp.toString());
    }

    public static void newBorrowsEvent() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Member's Name: ");
        String name = scn.nextLine();
        Member mem = (Member) Person.getPerson(name);

        System.out.println("Media's ISSN/ISBN to borrow: ");
        String id = scn.nextLine();
        LibraryCollection media = LibraryCollection.getMedia(id);

        System.out.println(name + " is borrowing " + id + "...");
        if (mem.checkOut(media)) {
            System.out.println(name + " borrowed " + id);
        } else {
            System.out.println(name + " couldn't borrow " + id);
        }
    };

    public static void newReturnEvent() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Member's Name: ");
        String name = scn.nextLine();
        Member mem = (Member) Person.getPerson(name);

        System.out.println("Media's ISSN/ISBN to return: ");
        String id = scn.nextLine();
        LibraryCollection media = LibraryCollection.getMedia(id);

        System.out.println(name + " is returning " + id + "...");
        if (mem.returnMedia(media)) {
            System.out.println(name + " returned " + id);
        } else {
            System.out.println(name + " couldn't return " + id);
        }
    };

    public static void newCheckOverdues() {
        LibraryCollection.checkOverdues();
    };

    // You are free to implememnt other events that you see needs to be implemented

    public static void main(String[] args) {
        Main.mainMenu();

        System.out.print("Enter your option number: ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int option = scanner.nextInt();
            try {
            switch (option) {
                case 10:
                    Person.printPeople();
                    break;
                case 20:
                    LibraryCollection.printCollection();
                    break;
                case 1:
                    Main.newMemberEvent();
                    break;
                case 11:
                    Main.loadMemberEvent();
                    break;
                case 2:
                    Main.newCollectionEvent();
                    break;
                case 3:
                    Main.newRemoveMemberEvent();
                    break;
                case 4:
                    Main.newRemoveCollectionEvent();
                    break;
                case 5:
                    Main.newEmployeeEvent();
                    break;
                case 51:
                    Main.loadEmployeeEvent();
                    break;
                case 6:
                    Main.newBorrowsEvent();
                    break;
                case 7:
                    Main.newReturnEvent();
                    break;
                case 8:
                    Main.newCheckOverdues();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid operator.");
                    continue;
            }
        } catch (Exception e) {
            System.out.println("Invalid input errored out, please choose again");
        }
        Main.mainMenu();
    }

    }
}