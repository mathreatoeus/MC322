import library.*;
import people.User;
import people.Student;
import people.FacultyUser;
import people.LibraryStaff;
import people.ExternalUser;
import people.UniversityStaff;

/**
 * ShelfSense Library Management System.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 * @version 1.1.0
 */

class Main {
    public static void main(String[] args) {
        // Testing report generation ----------------------------------------------------

        // Creating users
        Student m244088 = new Student("Matheus", "Reato", "54.981.976-9",
                "m244088@dac.unicamp.br", "Mp@5fg*9200769", 244088,
                false);

        Student c242908 = new Student("Caio", "Taishi", "45-654-723-4",
                "c242908@dac.unicamp.br", "pass123word", 242908,
                true);

        // Creating library and media items
        Library bif = new Library("IFGW");

        Book physics = new Book("Principles and Practice of Physics", "dunno",
                "Eric",
                "Mazur", "Classical Physics", "Physics", 9,
                10, 1);

        bif.addBook(physics);

        Magazine IEEEMicrowave = new Magazine("IEEE Microwave", "PDF",
                "IEEE Microwave", "Electromagnetism", "Electromagnetism",
                "IEEE", 2023, 8, 1, 3);

        bif.addMagazine(IEEEMicrowave);

        // Creating Loans
        Loan matheusLoan = new Loan(bif, physics, m244088);
        matheusLoan.renewLoan();

        Loan caiosLoan = new Loan(bif, IEEEMicrowave, c242908);
        caiosLoan.renewLoan();
    }
}