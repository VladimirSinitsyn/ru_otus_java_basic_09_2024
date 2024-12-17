package homework3;

public class Homework3 {
    public static void main(String[] args) {
        /**
         * Реализовать метод sumOfPositiveElements(..),
         * принимающий в качестве аргумента целочисленный двумерный массив, метод должен посчитать и вернуть сумму
         * всех элементов массива, которые больше 0;
         */
        sumOfPositiveElements();
        /**
         * Реализовать метод, который принимает в качестве аргумента int size
         * и печатает в консоль квадрат из символов * со сторонами соответствующей длины;\
         */
        printSquare(5);

        /**
         * Реализовать метод, принимающий в качестве аргумента квадратный двумерный целочисленный массив, и зануляющий
         * его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе).
         * Проверять количество строк и столбцов не требуется, условие “квадратности” нужно чтобы упростить вам работу с диагоналями;
         */
        nullDiagonals();
        /**
         * Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
         */
        findMax();

        /**
         * Реализуйте метод, который считает сумму элементов второй строки или столбца двумерного массива (по вашему выбору),
         * если второй строки/столбца не существует, то в качестве результата необходимо вернуть -1
*/
    countSumOfSecondRow();}


    public static void sumOfPositiveElements() {
        int[][] arr1 = {
                {-1, 2, 3},
                {4, -5, 6},
                {7, 8, 9,}};
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] >= 0) {
                    sum += arr1[i][j];
                }
            }
        }
        System.out.println(sum);
    }

    public static void printSquare(int size) {
        char side = '*';
        char[][] arr2 = new char[size][size];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = side;
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void nullDiagonals() {
        int[][] arr3 = {
                {-1, 2, 3},
                {4, -5, 6},
                {7, 8, 9}
        };
        int nullArrayDiagonal = 0;
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                if (i == j) {
                    arr3[i][j] = nullArrayDiagonal;
                }
                System.out.print(arr3[i][j]);
            }
            System.out.println(" ");

        }
    }


    public static void findMax() {
        int[][] arr4 = {
                {-1, 2, 13},
                {4, -5, 6},
                {7, 8, 9,}};

int maxElement=arr4[0][0];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if (arr4[i][j]>maxElement ) {
                    maxElement=arr4[i][j];
                }
            }
        }
        System.out.println(maxElement);
    }

    public static void countSumOfSecondRow() {
        int[][] arr5 = {
                {-1, 2, 13},
                {4, -5, 6},
                {7, 8, 9,}};
        int sum=0;
        for (int i = 0; i < arr5.length; i++) {
            for (int j = 0; j < arr5.length; j++) {
                if (i == 1) {
                    sum += arr5[i][j];
                }

            }

        }
        System.out.println(sum);
    }
}


//  public static void sumOfPositiveElements() {




