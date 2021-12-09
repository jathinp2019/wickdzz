
import java.util.*;

/*Define a base class named university with data members as university name, headquarters_location,no_of_courses_offered.
 Include a constructor and method to display the university details.

 Derive a class named college which has its data members such as faculty_count and no_of_departments. This class includes a member function to display the details related college. Derive another class named department for which the parent class is college and has its members as no_of_students and no_of_labs. Implement the following concepts in the given program.

// Creation of objects for the derived classes.  
   */
public class inh1 {
    public static void main(String[] args) {
        System.out.println("University: ");
        university u = new university();
        department d = new department();
        d.show();
        d.display();
    }
}

class university {
    String u_name = "ABC", u_loc = "XYZ";
    int n_course = 10;

    university() {
        System.out.println("name: " + u_name);
        System.out.println("location: " + u_loc);
        System.out.println("no. of course: " + n_course);
    }
}

class college {
    int n_faculty = 50, n_dept = 15;
    String nm_college = "QWE";

    void show() {
        System.out.println("\nName of college: " + nm_college);
    }
}

class department extends college {
    int n_student = 1200, n_labs = 8;

    void display() {
        System.out.println("no. of faculty: " + super.n_faculty);
        System.out.println("no. of dept: " + super.n_dept);
        System.out.println("no. of student: " + n_student);
        System.out.println("no. of labs: " + n_labs);
    }
}