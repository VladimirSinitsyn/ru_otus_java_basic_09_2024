package homework6;

public class Plate {
    private int plateCapacity;
    private int currentQuantityOfFood;

    public Plate(int plateCapacity) {
        this.plateCapacity = plateCapacity;
        this.currentQuantityOfFood = addFood();

    }

    public int getPlateCapacity() {
        return plateCapacity;
    }

    public void setPlateCapacity(int plateCapacity) {
        this.plateCapacity = plateCapacity;
    }

    public int getCurrentQuantityOfFood() {
        return currentQuantityOfFood;
    }

    public void setCurrentQuantityOfFood(int currentQuantityOfFood) {
        this.currentQuantityOfFood = currentQuantityOfFood;
    }

    public void plateStatus(){
        System.out.println("Инфо ---------------------" +
                "\nОбъем тарелки: "+ plateCapacity + "\n Текущее количество еды: "+ currentQuantityOfFood
                + "\n-------------------------");
    }
    public int addFood(){

        return currentQuantityOfFood = plateCapacity;
    }
    public boolean eatFood(int foodQuantity) {
        if (foodQuantity <= currentQuantityOfFood) {
            currentQuantityOfFood -= foodQuantity;
        } else {
            return false;
        }
        return true;
    }




}

