package collections.extension;

import java.util.*;

public class Contact {
    private String name;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact other = (Contact) o;
        // so sanh phone cua 2 contact
        return Objects.equals(phoneNumber, other.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return name + " (" + phoneNumber + ")";
    }
    public static void main(String[] args) {
        List<Contact> contacts = List.of (
                new Contact("Nam", "0901"),
                new Contact("An", "0902"),
                new Contact("Binh", "0903"),
                new Contact("Nam 2", "0901"),   // trùng phone
                new Contact("Chi", "0904"),
                new Contact("An 2", "0902"),    // trùng phone
                new Contact("Dung", "0905"),
                new Contact("Bach", "0906"),
                new Contact("Minh", "0907"),
                new Contact("Ha", "0908")
        );
        HashSet <Contact> uniqueContacts = new HashSet<>(contacts);
        Iterator<Contact> it = uniqueContacts.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
