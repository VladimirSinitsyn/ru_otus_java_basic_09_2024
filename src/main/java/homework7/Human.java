package homework7;

public class Human {
    public String name;
    private Transport currentTransport;


    public Human(String name) {
        this.name = name;
        currentTransport=null;
    }

    public void changeTransport(Transport transport) {
        currentTransport=transport;
    }

    public boolean move(int distance, TypeOfPlace  typeOfPlace) {
        if(currentTransport==null) {
            System.out.println(name+" идет пешком " + distance + " метров по " + typeOfPlace );
            return true;
        } else {
            return currentTransport.move(distance, typeOfPlace);
        }
    }
}
