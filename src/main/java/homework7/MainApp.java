package homework7;

/**
 * ●  Создайте класс Человек с полями name (имя) и currentTransport (текущий транспорт)
 * ● Реализуйте в вашем приложении классы Машина, Лошадь, Велосипед, Вездеход
 * ● Каждый из классов должен предоставлять возможность переместиться на определенное расстояние с
 * указанием типа местности
 * ● В приложении должны быть типу местности: густой лес, равнина, болото
 * ● Человек должен иметь возможность сесть на любой из этих видов транспорта, встать с него, или
 * переместиться на некоторое расстояние (при условии что он находится на каком-либо транспорте)
 * ● При попытке выполнить перемещение у человека, не используемого транспорт, считаем что он просто идет
 * указанное расстояние пешком
 * ● При перемещении Машина и Вездеход тратят бензин, который у них ограничен. Лошадь тратит силу.
 * Велосипед может использоваться без ограничений (можете для усложнениā велосипедом тратить силу
 * “водителя”). При выполнении действия результат должен быть отпечатан в консоль
 * ● У каждого вида транспорта есть местности по которым он не может перемещаться: машина - густой лес и
 * болото, лошадь и велосипед - болото, вездеход - нет ограничений
 * ● При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
 **/
public class MainApp {
    public static void main(String[] args) {
        Human human = new Human("Sergey");
        Horse horse = new Horse();
        Bicycle bicycle = new Bicycle();
        AllTerrain allTerrain = new AllTerrain();
        Car car = new Car();


        human.move(50, TypeOfPlace.SWAMP);
        human.move(50, TypeOfPlace.DEEP_FOREST);
        human.move(50, TypeOfPlace.PLANE);
        human.changeTransport(bicycle);
        human.move(50, TypeOfPlace.SWAMP);
        human.move(50, TypeOfPlace.DEEP_FOREST);
        human.move(50, TypeOfPlace.PLANE);
        human.changeTransport(allTerrain);
        human.move(50, TypeOfPlace.SWAMP);
        human.move(50, TypeOfPlace.DEEP_FOREST);
        human.move(50, TypeOfPlace.PLANE);
        human.changeTransport(car);
        human.move(50, TypeOfPlace.SWAMP);
        human.move(50, TypeOfPlace.DEEP_FOREST);
        human.move(50, TypeOfPlace.PLANE);
        human.changeTransport(horse);
        human.move(50, TypeOfPlace.SWAMP);
        human.move(50, TypeOfPlace.DEEP_FOREST);
        human.move(50, TypeOfPlace.PLANE);

    }
}
