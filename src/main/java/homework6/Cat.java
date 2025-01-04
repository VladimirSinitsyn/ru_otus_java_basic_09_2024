package homework6;

public class Cat {
    private String name;
    private int catAappetite;
    private boolean isFed;


    public Cat(String name, int catAappetite) {
        this.name = name;
        this.catAappetite = catAappetite;
        this.isFed = isFed;

    }

    public void catInfo() {
        System.out.println("Cat " + name + " appetite: " + catAappetite + " isFed: " + isFed);
    }

    public boolean catEat(Plate plate) {
        if (plate.getCurrentQuantityOfFood() > catAappetite) {
            plate.eatFood(catAappetite);
isFed = true;
            System.out.println(name + " Сыт. Уровень сытости: " + isFed);

            return isFed ;

        }

        else {
            isFed = false;
            System.out.println(name + " Не поел. Недостаточно еды в миске. Уровень сытости: " + isFed);
        }
        return isFed;
    }
}