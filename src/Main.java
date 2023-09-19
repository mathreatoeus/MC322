import controllers.LibraryController;
import controllers.PersonController;
import controllers.ReportController;
import models.library.content.Item;
import views.LibraryView;
import views.PersonView;
import views.ReportView;
import models.people.*;
import models.library.content.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

/**
 * ShelfSense Library Management System.
 *
 * @author Matheus Reato (RA: 244088), Caio Taishi (RA: 242908).
 * @version 1.6
 */

public class Main {
    public static void main(String[] args) {
        // Creating the scene -----------------------------------------------------------
        Student matheus = new Student("Matheus", "Reato", "12.345.678-9",
                "mathreatoeus", "wordpass", "randmoAddress",
                "email@email.com", "123", 244088, false);

        ReadingItem.Book calculus = new ReadingItem.Book("Calculus, Vol. 1", LocalDate.now(),
                15, "123123", "James", "Stuart", (byte) 9,
                ReadingItem.ConservationState.GOOD, "512.14A");

        ReadingItem.DailyNews estadao = new ReadingItem.DailyNews("Estadao", LocalDate.now(),
                3, "Estadao");

        // Instancing controllers
        LibraryController libController = new LibraryController();
        PersonController personController = new PersonController();
        ReportController reportController = new ReportController();

        // Instancing views
        LibraryView libView = new LibraryView(libController);
        PersonView personView = new PersonView(personController);
        ReportView reportView = new ReportView();

        libController.addItem(calculus);
        libController.addItem(estadao);
        personController.addUser(matheus);

        // Menu -------------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---- Library Menu ----");
            System.out.println();
            System.out.println("1. Item Management");
            System.out.println("2. User management");
            System.out.println("3. Report Generation and Statistics");
            System.out.println("4. Staff management");
            System.out.println("5. Exit");
            System.out.println();
            System.out.println();
            System.out.print("Enter an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Auxiliary variables.
                    Scanner itemScanner = new Scanner(System.in);
                    String itemSearchStringKey = "";
                    String secondaryStorage = "";
                    int itemSearchIntKey = 0;
                    Person personSearchResult = null;
                    Item itemSearchResult = null;
                    boolean operationResult;
                    boolean loopCondition = true;

                    while (loopCondition) {
                        System.out.println("---- Item Management ----");
                        System.out.println();
                        System.out.println("1. Display Items");
                        System.out.println("2. Display Active Loans");
                        System.out.println("3. Display Reserves");
                        System.out.println("4. Loan an Item");
                        System.out.println("5. Retrieve an Item");
                        System.out.println("6. Return to Main Menu");
                        System.out.println();
                        System.out.println();
                        System.out.println("Enter an option: ");

                        int itemManagementOption = itemScanner.nextInt();

                        // Analyzing options.
                        switch (itemManagementOption) {
                            case 1:
                                libView.displayItems();
                                break;
                            case 2:
                                libView.displayActiveLoans();
                                break;
                            case 3:
                                libView.displayReserves();
                                break;
                            case 4:
                                System.out.println("Insert the item's ID: ");
                                itemSearchStringKey = itemScanner.nextLine();

                                System.out.println("Insert the user's social ID: ");
                                secondaryStorage = itemScanner.nextLine();

                                itemSearchResult = libController.searchItemById(itemSearchStringKey);
                                personSearchResult = personController.searchUserBySocialId(secondaryStorage);

                                operationResult = libController.lendItem(itemSearchResult, personSearchResult);

                                if (operationResult) {
                                    System.out.println("Loan completed successfully!");
                                } else {
                                    System.out.println("The loan failed to be completed.");
                                }

                                break;
                            case 5:
                                // Retrieval logic will go here...
                                break;
                            case 6:
                                loopCondition = false;
                                break;
                            default:
                                System.out.println("Invalid option.");
                                break;
                        }
                    }

                    break;
                case 2:
                    // Auxiliary variables.
                    Scanner userScanner = new Scanner(System.in);

                    String searchStringKey = "";
                    int searchIntKey = 0;
                    Person searchResult = null;
                    boolean userLoopCondition = true;

                    while (userLoopCondition) {
                        System.out.println("---- User Management ----");
                        System.out.println();
                        System.out.println("1. Display User List");
                        System.out.println("2. Search User by Social ID");
                        System.out.println("3. Search User by Student ID");
                        System.out.println("4. Search User by University Staff ID");
                        System.out.println("5. Search User by Faculty ID");
                        System.out.println("6. Add User");
                        System.out.println("7. Remove User");
                        System.out.println("8. Return to Main Menu");
                        System.out.println();
                        System.out.println();
                        System.out.println("Enter an option: ");

                        int userManagementOption = userScanner.nextInt();

                        // Analyzing options.
                        switch (userManagementOption) {
                            case 1:
                                personView.displayUsers();
                                break;
                            case 2:
                                System.out.println("Insert the user's social Id (xx.xxx.xxx-x): ");
                                searchStringKey = userScanner.nextLine();

                                searchResult = personController.searchUserBySocialId(searchStringKey);

                                if (searchResult != null) {
                                    System.out.println(searchResult.toString());
                                } else {
                                    System.out.println("User not found.");
                                }

                                break;
                            case 3:
                                System.out.println("Insert the student ID: ");
                                searchIntKey = userScanner.nextInt();
                                searchResult = personController.searchUserByStudentId(searchIntKey);

                                if (searchResult != null) {
                                    System.out.print(searchResult.toString());
                                } else {
                                    System.out.print("User not found.");
                                }

                                break;
                            case 4:
                                System.out.println("Insert University Staff ID: ");
                                searchIntKey = userScanner.nextInt();
                                searchResult = personController.searchUserByUniStaffId(searchIntKey);

                                if (searchResult != null) {
                                    System.out.print(searchResult.toString());
                                } else {
                                    System.out.println("User not found.");
                                }

                                break;
                            case 5:
                                System.out.println("Insert faculty ID: ");
                                searchIntKey = userScanner.nextInt();
                                searchResult = personController.searchUserByFacultyId(searchIntKey);

                                if (searchResult != null) {
                                    System.out.println(searchResult.toString());
                                } else {
                                    System.out.println("User not found.");
                                }

                                break;
                            case 6:
                                System.out.println("Adding feature is not ready yet...");
                                break;
                            case 7:
                                System.out.println("Removing feature is not ready yet...");
                                break;
                            case 8:
                                userLoopCondition = false;
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                                break;
                        }
                    }

                    break;
                case 3:
                    // Option 3...
                    break;
                case 4:
                    // Option 4...
                    break;
                case 5:
                    System.out.println("Exiting the menu...");
                    System.out.println("Goodbye!");
                    scanner.close();

                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
