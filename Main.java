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
        System.out.println("1. New Membership");
        System.out.println("11. Load Membership");
        System.out.println("2. New Collection");
        System.out.println("3. Remove Membership");
        System.out.println("4. Remove Item from Collection");
        System.out.println("5. New Employee");
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

        LibraryCollection media;
        try {
            switch (type) {
                case ("Book"):
                    media = new Book(id, section);
                    break;
                case ("DVD"):
                    media = new DVD(id, section);
                    break;
                case ("Journal"):
                    media = new Journal(id, section);
                    break;
                case ("Newspaper"):
                    media = new Newspaper(id, section);
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
    };

    public static void newEmployeeEvent() {
    };

    public static void newBorrowsEvent() {
    };

    public static void newReturnEvent() {
    };

    public static void newCheckOverdues() {
    };
    // You are free to implememnt other events that you see needs to be implemented

    public static void main(String[] args) {
        Main.mainMenu();

        System.out.print("Enter your option number: ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int option = scanner.nextInt();
            switch (option) {
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
        }

    }
}