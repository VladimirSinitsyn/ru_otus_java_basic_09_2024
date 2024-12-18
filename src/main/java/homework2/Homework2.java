package homework2;

import java.util.ArrayList;
import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) {
        //printStringForNTimes(50, "привет");
        //printSumArray(1);
        //fillArrayByNumber(6, new int[]{1, 2, 3, 5, 7, 1, 8, 2, 3, 10});
        //increaseToNumber(6, new int[]{1, 2, 3, 5, 7, 1, 8, 2, 3, 10});
        printWhichPartOfArrayIsBigger(new int[]{1, 2, 3, 5, 7, 1, 8, 2, 3, 10});
        /*Реализуйте метод, принимающий в качестве аргумента целочисленный массив,
        и печатающий в консоль информацию о том,
        сумма элементов какой из половин массива больше;*/
    }


    public static void printWhichPartOfArrayIsBigger(int[] arr1) {
        int sumPart1 = 0;
        int sumOfAllArr1 = 0;

        for (int i = 0; i < arr1.length / 2; i++) {
            sumPart1 += arr1[i];
        }

        for (int j = 0; j < arr1.length; j++) {
           sumOfAllArr1 += arr1[j];
        }
        int sumPart2=sumOfAllArr1-sumPart1;

        if (sumPart1>sumPart2) {
            System.out.println("Сумма элементов первой половины массива больше и составляет " + sumPart1);
        }else System.out.println("Сумма элементов второй половины массива больше и составляет " +sumPart2);

        System.out.println("Весь массив " +sumOfAllArr1);
        System.out.println("Первая часть "+ sumPart1);
        System.out.println("Вторая часть " + sumPart2);
        System.out.println("Вывод всего массива \n" +Arrays.toString(arr1));
    }

    public static void increaseToNumber(int number, int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] + number;
        }
        System.out.println(Arrays.toString(arr1));
    }

    public static void fillArrayByNumber(int number, int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = number;
        }
        System.out.println(Arrays.toString(arr1));


    }

    public static void printStringForNTimes(int ntime, String text) {
        for (int i = 0; i < ntime; i++) {
            System.out.println(text);
        }
    }

    public static void printSumArray(int thresholdNumber) {
        int sum = 0;
        int[] array1 = {1, 2, 3, 5, 7, 1, 8, 2, 3, 10};
        for (int i : array1) {
            if (i > thresholdNumber) {
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }

    {
//1,2,3,5,7,1,8,2,3,10
    }
}
