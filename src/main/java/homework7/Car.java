package homework7;

public class Car implements Transport {
    private int fuel;

    public Car() {
        this.fuel = 100;

    }

    @Override
    public boolean move(int distance, TypeOfPlace place) {
        if (place == TypeOfPlace.DEEP_FOREST || place == TypeOfPlace.SWAMP) {
            System.out.println("Машина Не может перемещаться по " + place.name());
            return false;
        }
        if (fuel >= distance) {
            fuel -= distance;
            System.out.println("Машина перемещается на " + distance + " километров по равнине");
            return true;
        }
        System.out.println("Недостаточно топлива");
        return false;
    }
}




