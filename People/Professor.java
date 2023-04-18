package People;

import Utils.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Professor extends Member {
    ArrayList<Student> mentees;

    public Professor(String name, String address, Email email, Login login, LocalDate dob, SSN ssn) {
        super(name, address, email, login, dob, ssn);
    }

    public Professor(Object mem) {
        super(mem);
    }

    public boolean addStudent(Student student) {
        if (mentees.contains(student)) {
            return false;
        } else {
            mentees.add(student);
            return true;
        }
    }

    public boolean removeStudent(Student student) {
        return mentees.remove(student);
    }

    public ArrayList<Student> getStudents() {
        return mentees;
    }
}
