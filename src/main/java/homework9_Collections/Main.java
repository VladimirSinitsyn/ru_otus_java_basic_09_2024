package homework9_Collections;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = diapazonMinMax(-3, 40);


        //diapazonMinMax(10,40);
        // sumOfElementsMoreThen5(List.of(0, 20, 30, 40, 50));
        // sumOfElementsMoreThen5(list);
        // rewriteCellByNumber(3,list);
        // incrementElementsOnNumber(5,list);
        System.out.println(list);

    }

    public static ArrayList<Integer> diapazonMinMax(int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);

        }
        System.out.println(list);
        return list;

    }

    public static int sumOfElementsMoreThen5(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            if (number > 5) {
                sum += number;
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static void rewriteCellByNumber(int number, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                list.set(i, number);
            }
        }

    }

    public static void incrementElementsOnNumber(int number, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                list.set(i, list.get(i) + number);
            }
        }

    }
}
/*Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, увеличивающий каждый элемент списка на указанное число;
 */