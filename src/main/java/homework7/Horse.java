package homework7;

public class Horse implements Transport {
    private int strength;

    public Horse() {
        this.strength = 100;
    }


    @Override
    public boolean move(int distance, TypeOfPlace place) {
        if (place == TypeOfPlace.SWAMP) {
            System.out.println("Лошадь не может перемещаться по болоту");
            return false;
        }
        if (strength >= distance) {
            strength -= distance;
            System.out.println("Человек перемещается на " + distance + "километров на лошади по "+ place.getType());
            return true;
        }
        return false;
    }
}
