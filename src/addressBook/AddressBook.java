package addressBook;

import java.util.ArrayList;
import java.util.Scanner;

//AddressBook class to hold entry classes.
public class AddressBook {

    private ArrayList<Entry> listOfEntries = new ArrayList<>();

    public AddressBook(){}

    //Method to add a new entry.
    public void addEntry(Scanner input){
        Entry newEntry = new Entry();
        System.out.println("Please enter your first name: ");
        String firstName = input.nextLine();
        newEntry.setFirstName(firstName);
        System.out.println("Please enter your last name: ");
        newEntry.setLastName(input.nextLine());
        System.out.println("Please enter your phone number: ");
        newEntry.setPhoneNumber(input.nextLine());
        System.out.println("Please enter your email address: ");
        newEntry.setEmailAddress(input.nextLine());
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
                sliceSearch(input);
                break;
            case "2":
                System.out.println("Enter your last name search:");
                sliceSearch(input);
                break;
            case "3":
                System.out.println("Enter your phone number search:");
                sliceSearch(input);
                break;
            case "4":
                System.out.println("Enter your email address search:");
                sliceSearch(input);
                break;
            default:
                System.out.println("Please enter a number between 1 and 4 next time to select your choice.");
        }
    }

    //Method to remove an entry
    public void removeEntry(Scanner input){
        System.out.println("Enter an entry's email to remove: ");
        String emailToRemove = input.nextLine();
        Entry entryToDelete = new Entry();
        for(Entry entry: this.listOfEntries) {
            if (emailToRemove.equalsIgnoreCase(entry.getEmailAddress())) {
                entryToDelete = entry;
                break;
            }
        }
        printEntry(entryToDelete);
        listOfEntries.remove(entryToDelete);
    }

    //Method to print the entire address book.
    public void printAddressBook(){
        for(Entry entry: this.listOfEntries) {
            printEntry(entry);
        }
    }

    //Method to clear the address book
    public void deleteEntries(){
        this.listOfEntries = new ArrayList<>();
        System.out.println("Address book cleared!");
    }

    //Helper method to print an entry
    public void printEntry(Entry entry) {
        System.out.println("************");
        System.out.println("First Name: " + entry.getFirstName());
        System.out.println("Last Name: " + entry.getLastName());
        System.out.println("Phone Number: " + entry.getPhoneNumber());
        System.out.println("Email: " + entry.getEmailAddress());
        System.out.println("************");
    }

    //Helper method to search a string with a substring
    public void sliceSearch(Scanner input){
        String searchTerm = input.nextLine();
        boolean entryFound = false;
        for(Entry entry: this.listOfEntries) {
            String slicedEntry = entry.getFirstName().substring(0, searchTerm.length());
            if(slicedEntry.equalsIgnoreCase(searchTerm)){
                System.out.println("Entry found!");
                entryFound = true;
                printEntry(entry);
            }
        }
        if(!entryFound) {
            System.out.println("Entry/Entries not found");
        }
    }
}
