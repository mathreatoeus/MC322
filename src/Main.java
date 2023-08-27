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
        Student m244088 = new Student("Matheus", "Reato", "54.981.976-9",
                "m244088@dac.unicamp.br", "Mp@5fg*9200769", 244088, false);

        Report loanReport = new Report("Loan", m244088);

        loanReport.generateReport();
    }
}