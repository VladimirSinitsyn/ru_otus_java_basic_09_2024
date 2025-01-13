package homework7;

public class AllTerrain implements Transport {
    private int fuel;

    public AllTerrain() {
        this.fuel = 100;
    }

    @Override
    public boolean move(int distance, TypeOfPlace place) {
        if (fuel >= distance) {
            fuel -= distance;
            System.out.println("Внедорожник перемещается на " + distance + " километров по " + place.getType());
            return true;
        }
        System.out.println("Недостаточно топлива");
        return false;
    }
}
