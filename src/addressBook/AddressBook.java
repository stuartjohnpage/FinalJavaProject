package addressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    private ArrayList<Entry> listOfEntries = new ArrayList<>();

    public AddressBook(){}

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

    public void searchForEntry(Scanner input) {

    }

    public void removeEntry(Scanner input){

    }
    public void printAddressBook(){

        for(Entry entry: this.listOfEntries) {
            System.out.println("************");
            System.out.println("First Name: " + entry.getFirstName());
            System.out.println("Last Name: " + entry.getLastName());
            System.out.println("Phone Number: " + entry.getPhoneNumber());
            System.out.println("Email: " + entry.getEmailAddress());
            System.out.println("************");
        }
    }

    public void deleteEntries(Scanner input){
        this.listOfEntries = new ArrayList<>();
    }
}
