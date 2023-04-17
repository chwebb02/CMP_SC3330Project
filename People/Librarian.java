package People;

import LibraryEvents.newMember;
import Utils.*;
import java.time.LocalDate;
import People.Member;
import People.Student;

public class Librarian extends Employee{
    Librarian(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }
    static public void newMemberEvent()
    {
        newMember a=new newMember();
        a.setnMember();
        System.out.println("HEllo from Libaraian new member event");
        //   public Member(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
       // Student q=new Student(a.getName(), a.getAddress(), a.getEmail(), a.getLogin(), a.getDob(), a.getSSN());
        Student x=new Student(a.name,a.address,a.email, a.login,a.dob,a.ssn);
        
    }



}
