package homework7;

public class Bicycle implements Transport {
    private int strength;


    public Bicycle() {
        this.strength = 100;

    }

    @Override
    public boolean move(int distance, TypeOfPlace place) {
        if (place == TypeOfPlace.SWAMP) {

            System.out.println("Велосипед не может перемещаться по болоту");
            return false;
        }
        if (strength >= distance) {
            strength -= distance;
            System.out.println("Человек перемещается на " + distance + "километров на велосипеде по " + place.getType());
            return true;
        }
        return false;
    }
}
