import library.Book;
import library.Library;
import library.Loan;
import people.Person;
import people.User;
import people.Staff;

/**
 * ShelfSense Library Management System.
 *
 * @author Matheus Reato (RA: 244088).
 * @version 1.0
 */

class Main {
    public static void main(String[] args) {
        // Testing the User class -------------------------------------------------------

        System.out.println("------- Testing User Class -------");

        User leonard = new User("Leonard", "Hofstadter", "123-45-6789",
                "lasermaster", "whoCon2015");

        // memberId hash test --> Pass

        System.out.println(leonard.getMemberId());

        // changeUsername() method test --> Pass

        String leonardsUsername = leonard.getUsername();

        boolean changeTrial = leonard.changeUsername("kingofnerds",
                "whoCon2015");

        System.out.println(changeTrial);
        leonardsUsername = leonard.getUsername();
        System.out.println(leonardsUsername);

        System.out.println("----------------------");

        // changePassword() method test --> Pass

        String leonardsPassword = leonard.getPassword();

        changeTrial = leonard.changePassword("whoCon2015",
                "LuckyInhaler");

        System.out.println(changeTrial);
        leonardsPassword = leonard.getPassword();
        System.out.println(leonardsPassword);


        // Testing the Staff class ------------------------------------------------------

        System.out.println("------- Testing Staff Class -------");

        Staff sheldon = new Staff("Sheldon", "Cooper", "098-76-5432",
                "String Theory", "sheldor", "hoGaugeTrains");

        // Staff ID hash test --> Pass

        System.out.println(sheldon.getStaffId());

        // changeUsername() method test --> Pass

        System.out.println(sheldon.getUsername());

        changeTrial = sheldon.changeUsername("geologyAstrology",
                "hoGaugeTrains");

        System.out.println(changeTrial);
        System.out.println(sheldon.getUsername());

        System.out.println("----------------------");

        // changePassword() method test --> Pass

        System.out.println(sheldon.getPassword());

        changeTrial = sheldon.changePassword("notARealScience",
                "hoGaugeTrains");

        System.out.println(changeTrial);
        System.out.println(sheldon.getPassword());

        // Testing the Book class -------------------------------------------------------

        System.out.println("------- Testing Book Class -------");

        Book leavesOfGrass = new Book("Leaves of Grass", "Walt",
                "Whitman", "American Poetry", "Poetry", 1, 1);

        System.out.println(leavesOfGrass.getGenre());

        // incrementTimesBorrowed() method test --> Pass

        System.out.println(leavesOfGrass.getTimesBorrowed());
        changeTrial = leavesOfGrass.incrementTimesBorrowed();
        System.out.println(changeTrial);
        System.out.println(leavesOfGrass.getTimesBorrowed());

        // Testing the Library class -----------------------------------------------------

        System.out.println("------- Testing Library Class -------");

        // Testing add methods --> Pass

        Library bif = new Library("IFGW");
        boolean addBookStatus = bif.addBook(leavesOfGrass);
        boolean addUserStatus = bif.addUser(leonard);
        boolean addStaffStatus = bif.addStaff(sheldon);

        System.out.println(bif.getInstitute());
        System.out.println(bif.getBooks());
        System.out.println(bif.getStaff());
        System.out.println(bif.getUsers());

        System.out.println("----------------------");

        // Testing remove methods --> Pass

        addBookStatus = bif.removeBook(leavesOfGrass);
        addUserStatus = bif.removeUser(leonard);
        addStaffStatus = bif.removeStaff(sheldon);

        System.out.println(bif.getInstitute());
        System.out.println(bif.getBooks());
        System.out.println(bif.getStaff());
        System.out.println(bif.getUsers());

        // Testing the Loan class --------------------------------------------------------

        System.out.println("------- Testing Loan Class -------");

        addBookStatus = bif.addBook(leavesOfGrass);
        addUserStatus = bif.addUser(leonard);
        addStaffStatus = bif.addStaff(sheldon);

        Book calculusJamesStuart = new Book("Calculus, Vol 1", "James",
                "Stuart", "Calculus", "Non-fition", 9, 2);

        bif.addBook(calculusJamesStuart);

        // Testing constructors and book availability check --> Pass

        Loan leonardsLoan = new Loan(bif, leavesOfGrass, leonard);
        System.out.print("Leonard's loan of Leaves of Grass: ");
        System.out.println(leonardsLoan.getBook());

        Loan sheldonsLoan1 = new Loan(bif, leavesOfGrass, sheldon);
        System.out.print("Sheldon's loan of Leaves of Grass: ");
        System.out.println(sheldonsLoan1.getBook());

        Loan sheldonsLoan2 = new Loan(bif, calculusJamesStuart, sheldon);
        System.out.print("Sheldon's loan of Calculus, Vol 1: ");
        System.out.println(sheldonsLoan2.getBook());

        System.out.println("----------------------");

        // Testing renewals --> Pass

        System.out.print("Leonard's retrieval date: ");
        System.out.println(leonardsLoan.getRetrievalDate());

        leonardsLoan.renewLoan();

        System.out.print("Leonard's new retrieval date: ");
        System.out.println(leonardsLoan.getRetrievalDate());

        // Testing the loan's expiration date check --> Pass

        System.out.println(leonardsLoan.checkExpiration());
    }
}