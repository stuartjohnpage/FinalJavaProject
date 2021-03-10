package addressBook;

public class Entry {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "addressBook.Entry{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    //Helper method to help search for substrings
    public String searchOperation(int operation) {
        if(operation == 1){
            return this.getFirstName();
        }else if(operation == 2){
            return this.getLastName();
        }else if(operation == 3) {
            return this.getPhoneNumber();
        }else {
            return this.getEmailAddress();
        }
    }
}
