import java.util.Scanner;

import Collections.LibraryCollection;
import Utils.Login;
import People.Person;

public class Main {
    public static Login logIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("LOGIN:\n\tUSERNAME: ");
        String username = scanner.nextLine();

        System.out.print("\tPASSWORD: ");
        String password = scanner.nextLine();

        scanner.close();
        System.out.println();

        return new Login(username, password);
    }

    public static void main(String[] args) {
        // Log in to the library system
        Login attempt;
        do {
            attempt = logIn();
        } while (Person.lookup(attempt.getUsername()).getLogin().verify(attempt));      // This is gross but also awesome
        Person session = Person.lookup(attempt.getUsername());

        // Enter the session loop, logout when ended
        session.menu();
        session.logout();

        LibraryCollection.save();
        // Person.save();           // This needs to be implemented
    }
}
