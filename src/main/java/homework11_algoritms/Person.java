package homework11_algoritms;

public class Person {
    Long id;
    String name;
    Position position;

    public Person(Long id, Position position, String name) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Long getId() {
        return id;
    }
}
