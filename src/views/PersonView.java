package views;

import controllers.PersonController;
import models.people.Person;
import java.util.ArrayList;

public class PersonView {
    //Private Attributes ----------------------------------------------------------------
    PersonController personController;

    //Constructor -----------------------------------------------------------------------
    public PersonView(PersonController personController) {
        this.personController = personController;
    }

    // Methods --------------------------------------------------------------------------

    /**
     * Displays the list of users of the Person Controller.
     */
    public void displayUsers() {
        ArrayList<Person> users = (this.personController).listUsers();

        for (Person user : users) {
            System.out.println("-------------------------");
            System.out.println(user.toString());
            System.out.println("-------------------------");
        }
    }
}
