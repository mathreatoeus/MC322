import people.users.Student;

import java.time.LocalDate;

/**
 * ShelfSense Library Management System.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 * @version 1.4
 */

class Main {
    public static void main(String[] args) {
        Student matheus = new Student("Matheus", "Reato", "54-981-976-9", "mathreatoeus",
                "mypassword", "Rua Antonio Paioli, n 20", "m244088@dac.unicamp.br",
                "19 99892 8237", 244088, false);

        LocalDate mrd = matheus.getRegistrationDate();
        System.out.println(mrd);
    }
}