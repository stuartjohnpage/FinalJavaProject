package addressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    private ArrayList<Entry> listOfEntries = new ArrayList<>();

    public AddressBook() {
    }

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

    }
    public void deleteEntries(Scanner input){

    }
}
