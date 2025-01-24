package homework11_algoritms;

public class Main {

    public static void main(String[] args) {
        PersonDataBase db = new PersonDataBase();
        Person person1 = new Person(123L, Position.DIRECTOR, "Alexander Bulavin");
        Person person2 = new Person(234L, Position.MANAGER, "Sergey Nemtsev");
        Person person3 = new Person(345L, Position.BRANCH_DIRECTOR, "Petr Morozov");
        Person person4 = new Person(456L, Position.QA, "Sergey Dubov");
        db.add(person1);
        db.add(person2);
        db.add(person3);
        db.add(person4);
        db.findById(123L);
        boolean isManager1 = db.isManager(person4);
        boolean isManager2 = db.isManager(person3);
        System.out.println("isManager?: " + isManager1);
        System.out.println("isManager?: " + isManager2);
        boolean isEmployee1 = db.isEmployee(345L);
        boolean isEmployee2 = db.isEmployee(456L);
        System.out.println("isEmployee?: " + isEmployee1);
        System.out.println("isEmployee?: " + isEmployee2);

    }

}
