package homework11_algoritms;

import java.util.ArrayList;
import java.util.List;

public class PersonDataBase {
    private final List<Person> persons = new ArrayList<>();

    public Person findById(Long id) {
        for (Person person : persons) {
            if (person.getId().equals(id)) {
                System.out.println("Найден сотрудник с ID " + person.getId() + "\n" + person.getName());
                return person;
            }
        }
        return null;
    }

    public void add(Person person) {
        persons.add(person);

    }

    public boolean isManager(Person person) {
        return person.getPosition() == Position.MANAGER ||
                person.getPosition() == Position.DIRECTOR ||
                person.getPosition() == Position.BRANCH_DIRECTOR ||
                person.getPosition() == Position.SENIOR_MANAGER;

    }

    public boolean isEmployee(Long id) {
        Person person = findById(id);
        return !isManager(person);
    }
}

