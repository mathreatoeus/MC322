import library.Book;
import library.Library;
import library.Loan;
import people.Person;
import people.User;
import people.Staff;

/**
 * ShelfSense Library Management System.
 *
 * @author Matheus Reato (RA: 244088)
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
    }
}