package homework10_collections2;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    public List<Contacts> phoneBook = new ArrayList<>();

    public void add(String name, String phoneNumber) {
        Contacts contact = new Contacts(name, phoneNumber);
        phoneBook.add(contact);
        System.out.println(contact);
    }

    public List<String> find(String contactName) {
        List<String> list = new ArrayList<>();
        for (Contacts contact : phoneBook) {
            if (contact.getName().equals(contactName)) {
                list.add(contact.getPhoneNumber());
            }
        }
        System.out.println(list);
        return list;
    }

    public boolean consistPhoneNumber(String phoneNumber) {
        for (Contacts contact : phoneBook) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
