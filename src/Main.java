import library.Book;
import library.Library;
import library.Loan;
import people.User;
import people.Student;
import people.FacultyUser;
import people.LibraryStaff;
import people.ExternalUser;
import people.UniversityStaff;
import library.Report;

/**
 * ShelfSense Library Management System.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 * @version 1.0
 */

class Main {
    public static void main(String[] args) {
        // Testing report generation ----------------------------------------------------
        Student m244088 = new Student("Matheus", "Reato", "54.981.976-9",
                "m244088@dac.unicamp.br", "Mp@5fg*9200769", 244088,
                false);

        Library bif = new Library("IFGW");

        Book physics = new Book("Principles and Practice of Physics", "dunno",
                "Eric",
                "Mazur", "Classical Physics", "Physics", 9,
                10, 1);

        Loan matheusLoan = new Loan(bif, physics, m244088);
        matheusLoan.renewLoan();
    }
}