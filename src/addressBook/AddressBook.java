package addressBook;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//AddressBook class to hold entry classes.
public class AddressBook {

    private ArrayList<Entry> listOfEntries = new ArrayList<>();

    public AddressBook() {
    }

    //Method to add a new entry.
    public void addEntry(Scanner input) {
        Entry newEntry = new Entry();
        addName(newEntry, input, true);
        addName(newEntry, input, false);
        addPhoneNumber(newEntry, input);
        addEmailAddress(newEntry, input);
        listOfEntries.add(newEntry);
        System.out.println("Added New Entry!");
    }

    //Method to search different fields
    public void searchForEntry(Scanner input) {
        System.out.println("1) First Name");
        System.out.println("2) Last Name");
        System.out.println("3) Phone Number");
        System.out.println("4) Email Address");
        System.out.println("Please chose a search type:  ");
        String userChoice = input.nextLine();
        switch (userChoice) {
            case "1":
                System.out.println("Enter your first name search:");
                sliceSearch(input,1);
                break;
            case "2":
                System.out.println("Enter your last name search:");
                sliceSearch(input, 2);
                break;
            case "3":
                System.out.println("Enter your phone number search:");
                sliceSearch(input, 3);
                break;
            case "4":
                System.out.println("Enter your email address search:");
                sliceSearch(input, 4);
                break;
            default:
                System.out.println("Please enter a number between 1 and 4 next time to select your choice.");
        }
    }

    //Method to remove an entry
    public void removeEntry(Scanner input) {
        System.out.println("Enter an entry's email to remove: ");
        boolean entryFound = false;
        String emailToRemove = input.nextLine();
        Entry entryToDelete = new Entry();
        for (Entry entry : this.listOfEntries) {
            if (emailToRemove.equalsIgnoreCase(entry.getEmailAddress())) {
                entryFound = true;
                entryToDelete = entry;
                break;
            }
        }
        if (entryFound) {
            System.out.println("Deleted the following entry:");
            printEntry(entryToDelete);
            listOfEntries.remove(entryToDelete);
        } else {
            System.out.println("Entry not found");
        }
    }

    //Method to print the entire address book.
    public void printAddressBook() {
        if (this.listOfEntries.size() == 0) {
            System.out.println("Address book empty!");
        }
        for (Entry entry : this.listOfEntries) {
            printEntry(entry);
        }
    }

    //Method to clear the address book
    public void deleteEntries() {
        this.listOfEntries = new ArrayList<>();
        System.out.println("Address book cleared!");
    }

    //Getter method to return the list of entries (used in the filesystem methods in main)
    public ArrayList<Entry> getListOfEntries() {
        return listOfEntries;
    }


    //Helper method to print an entry
    private void printEntry(Entry entry) {
        System.out.println("************");
        System.out.println("First Name: " + entry.getFirstName());
        System.out.println("Last Name: " + entry.getLastName());
        System.out.println("Phone Number: " + entry.getPhoneNumber());
        System.out.println("Email: " + entry.getEmailAddress());
        System.out.println("************");
    }

    //Helper method to search a string with a substring
    private void sliceSearch(Scanner input, int operation) {
        String searchTerm = input.nextLine();
        boolean entryFound = false;
        for (Entry entry : this.listOfEntries) {
            //entry.searchOperation(operation) returns the searched for attribute in the current entry.
            // It then sets sliced entry as the substring of that attribute starting from zero. This cannot
            //be longer than the searched for attribute - math.min ensures no index out of range errors
            String slicedEntry = entry.searchOperation(operation).substring(0, Math.min(searchTerm.length(),
                    entry.searchOperation(operation).length()));
            if (slicedEntry.equalsIgnoreCase(searchTerm)) {
                System.out.println("Entry found!");
                entryFound = true;
                printEntry(entry);
            }
        }
        if (!entryFound) {
            System.out.println("Entry/Entries not found");
        }
    }

    //helper Regex check for valid phone number
    private void addPhoneNumber(Entry entry, Scanner input) {
        boolean validPhoneNumber = false;
        String newPhoneNumber = null;
        while (!validPhoneNumber) {
            System.out.println("Please enter your phone number in the format ########## or ###-###-####:  ");
            newPhoneNumber = input.nextLine();
            Pattern pattern = Pattern.compile("^\\d{10}|\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d$");
            Matcher matcher = pattern.matcher(newPhoneNumber);
            validPhoneNumber = matcher.find();
        }
        entry.setPhoneNumber(newPhoneNumber);
    }

    //helper Regex check for valid email address
    private void addEmailAddress(Entry entry, Scanner input) {
        boolean validEmail = false;
        String newEmail = null;
        while (!validEmail) {
            boolean NotTakenEmail = true;
            System.out.println("Please enter your email address: ");
            newEmail = input.nextLine();
            Pattern pattern = Pattern.compile("^.+@{1}.+\\.{1}.+$");
            Matcher matcher = pattern.matcher(newEmail);

            for (Entry existingEntry : this.listOfEntries) {
                if (newEmail.equalsIgnoreCase(existingEntry.getEmailAddress())) {
                    NotTakenEmail = false;
                    System.out.println("This email address is already taken");
                }
            }
            validEmail = matcher.find() && NotTakenEmail;
        }
        entry.setEmailAddress(newEmail);
    }
    //Helper method to validate name entry
    private void addName(Entry entry, Scanner input, boolean firstName) {
        boolean validName = false;
        String newName = null;
        while (!validName) {
            if(firstName) {
                System.out.println("Please enter your first name - numbers are not allowed");
            }else{
                System.out.println("Please enter your last name - numbers are not allowed");
            }
            newName = input.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
            Matcher matcher = pattern.matcher(newName);
            validName = matcher.find();
        }
        if(firstName) {
            entry.setFirstName(newName);
        }else{
            entry.setLastName(newName);
        }
    }
}
