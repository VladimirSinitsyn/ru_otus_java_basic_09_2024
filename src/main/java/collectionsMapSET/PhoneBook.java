package collectionsMapSET;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Sergey Ivanov", "123456789");
        phoneBook.add("Elena Sergeeva", "987654321");
        phoneBook.add("Ivan Sidorov", "5555555");
        phoneBook.add("Sarah Paulson", "222335547");
        phoneBook.find("Sergey Ivanov");
        System.out.println(phoneBook.containsPhoneNumber("987654321"));
        System.out.println(phoneBook.phoneBook);
    }

    private final Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String contactName, String phoneNumber) {
        phoneBook.putIfAbsent(contactName, new HashSet<>());
        phoneBook.get(contactName).add(phoneNumber);
        System.out.println(contactName + " " + phoneNumber + " добавлен в телефонную книгу");
    }

    public Set<String> find(String contactName) {
        Set<String> phoneNumbers = phoneBook.get(contactName);
        if (phoneNumbers != null) {
            for (String phoneNumber : phoneNumbers) {

                System.out.println(contactName + " " + phoneNumber);
            }
        }
        return phoneNumbers;
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        for (Set<String> phoneNumbers : phoneBook.values()) {
            if (phoneNumbers.contains(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
