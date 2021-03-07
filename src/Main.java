import java.util.Scanner;

import addressBook.*;

public class Main {
    public static void main(String[] args) {

        AddressBook myAddressBook = new AddressBook();
        Scanner userInput = new Scanner(System.in);
        boolean notFinished = true;

        //Loop will run until user inputs that they are finished.
        while(notFinished) {
            System.out.println("1) Add an entry");
            System.out.println("2) Remove an entry");
            System.out.println("3) Search for a specific entry");
            System.out.println("4) Print Address Book");
            System.out.println("5) Delete Address Book");
            System.out.println("6) Quit");
            System.out.println("Please choose what you want to do with the database");
            //Asks the user to make their choice.

            int desiredOperation = makeAChoice(userInput);
            if(desiredOperation == 6) {
                notFinished = false;
            }
            executeDesiredOperation(desiredOperation, myAddressBook, userInput);
        }
        userInput.close();
        System.exit(0);
    }

    //Method to take input from the user (and make sure the choice is valid)
    public static int makeAChoice(Scanner input) {
        boolean validChoiceMade = false;
        String userChoice;
        int userChoiceAsNumber = 0;
        while (!validChoiceMade) {
            userChoice = input.nextLine();
            try {
                userChoiceAsNumber = Integer.parseInt(userChoice);
                if (userChoiceAsNumber >= 1 && userChoiceAsNumber <= 6) {
                    validChoiceMade = true;
                } else {
                    System.out.println("Please enter an integer matching the choices:");
                }
            } catch (Exception NumberFormatException) {
                System.out.println("Please enter an integer matching the choices:");
            }
        }
        return userChoiceAsNumber;
    }

    //Method to call the AddressBook class methods
    public static void executeDesiredOperation(Integer operationToExecute, AddressBook addressBook, Scanner input) {
        switch (operationToExecute) {
            case 1:
                addressBook.addEntry(input);
                break;
            case 2:
                addressBook.removeEntry(input);
                break;
            case 3:
                addressBook.searchForEntry(input);
                break;
            case 4:
                addressBook.printAddressBook();
                break;
            case 5:
                addressBook.deleteEntries();
                break;
        }
    }
}