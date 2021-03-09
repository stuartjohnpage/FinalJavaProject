/**
 * This FinalJavaProject is an implementation of an address book with multiple features. These include adding, searching
 * and deleting entries. Each entry has a unique email address associated with it. The address book is saved to a file
 * in the root folder, and can also be loaded from that file. This application just runs in the console.
 *
 *
 * @author  Stuart Page
 * @version 1.0
 * @since   03/09/2021
 */

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

import addressBook.*;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        boolean notFinished = true;
        AddressBook myAddressBook = createOrLoadAddressBookFile();

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
            saveAddressBookFile(myAddressBook);
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
                addressBook.addEntry(input,addressBook);
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

    //Method to create or load an address book file.
    public static AddressBook createOrLoadAddressBookFile(){
        AddressBook createdOrLoadedBook = new AddressBook();
        try {
            File file = new File("addressBook.txt");
            if (file.createNewFile()) {
                System.out.println("Address Book created: " + file.getName());
            } else {
                System.out.println("Address Book already exists.");
                createdOrLoadedBook = loadAddressBookFile();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return createdOrLoadedBook;
    }

    //Method to load an address book file if there is one to load.
    private static AddressBook loadAddressBookFile() {
        AddressBook myAddressBook = new AddressBook();
        try {
            File AddressBookFile = new File("addressBook.txt");
            Scanner myReader = new Scanner(AddressBookFile);
            while (myReader.hasNextLine()) {
                Entry newEntry = new Entry();
                newEntry.setFirstName(myReader.nextLine());
                newEntry.setLastName(myReader.nextLine());
                newEntry.setPhoneNumber(myReader.nextLine());
                newEntry.setEmailAddress(myReader.nextLine());
                myAddressBook.getListOfEntries().add(newEntry);
            }
            myReader.close();
            return myAddressBook;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return myAddressBook;
    }

    //Method to save address book file.
    public static void saveAddressBookFile(AddressBook addressBook){
        try {
            FileWriter myWriter = new FileWriter("addressBook.txt");
            for(Entry entry : addressBook.getListOfEntries()) {
                myWriter.write( entry.getFirstName()+ System.lineSeparator() + entry.getLastName() +
                        System.lineSeparator() + entry.getPhoneNumber() + System.lineSeparator() +
                        entry.getEmailAddress()+ System.lineSeparator());
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}