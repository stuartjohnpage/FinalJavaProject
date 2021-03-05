package addressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    private ArrayList<Entry> listOfEntries = new ArrayList<>();

    public AddressBook() {
    }

    public void addEntry(){
        Scanner scanner = new Scanner(System.in);
        Entry newEntry = new Entry();
        System.out.println("Please enter your first name: ");
        newEntry.setFirstName(scanner.next());
        System.out.println("Please enter your last name: ");
        newEntry.setLastName(scanner.next());
        System.out.println("Please enter your phone number: ");
    }
    public void searchForEntry() {

    }
    public void removeEntry(){

    }
    public void printAddressBook(){

    }
    public void deleteEntries(){

    }
}
