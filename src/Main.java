import java.util.Scanner;

import addressBook.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("1) Add an entry");
        System.out.println("2) Remove an entry");
        System.out.println("3) Search for a specific entry");
        System.out.println("4) Print Address Book");
        System.out.println("5) Delete Address Book");
        System.out.println("6) Quit");
        System.out.println("Please choose what you want to do with the database");

        AddressBook myAddressBook = new AddressBook();

        boolean choiceSelected = false;
        while(choiceSelected == false) {
            try {
                Scanner scanner = new Scanner(System.in);
                int userChoice = scanner.nextInt();
                switch (userChoice) {
                    case 1:
                        choiceSelected = true;
                        myAddressBook.addEntry();
                        break;
                    case 2:
                        choiceSelected = true;
                        myAddressBook.removeEntry();
                        break;
                    case 3:
                        choiceSelected = true;
                        myAddressBook.searchForEntry();
                        break;
                    case 4:
                        choiceSelected = true;
                        myAddressBook.printAddressBook();
                        break;
                    case 5:
                        choiceSelected = true;
                        myAddressBook.deleteEntries();
                        break;
                    case 6:
                        System.exit(0);
                        scanner.close();
                    default:
                        System.out.println("Please enter an integer between 1 and 6 to make your choice.");
                }
            } catch(Exception InputMismatchException ) {
                System.out.println("Please enter an integer between 1 and 6 to make your choice.");
            }
        }
    }
}
