package homework10_collections2;


public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Sergey Ivanov", "123456789");
        phoneBook.add("Elena Sergeeva", "987654321");
        phoneBook.add("Ivan Sidorov", "987654321");
        phoneBook.add("Sarah Paulson", "222335547");
        phoneBook.find("Elena Sergeeva");
        System.out.println(phoneBook.consistPhoneNumber("123456789"));

    }
}
