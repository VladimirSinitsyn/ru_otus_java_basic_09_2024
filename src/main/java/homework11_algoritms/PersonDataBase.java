package homework11_algoritms;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    private final Map<Long, Person> idPersonMap = new HashMap<>();

    public Person findById(Long id) {

                System.out.println("Найден сотрудник с ID " + idPersonMap.get(id) + "\n" + idPersonMap.get(id).getName());
                return idPersonMap.get(id);
            }

    public void add(Person person) {
        idPersonMap.put(person.getId(),person);

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

