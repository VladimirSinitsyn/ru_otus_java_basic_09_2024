package homework14.threads;

/**
 * Реализация №1
 * <p>
 * Реализуйте метод, который создает double массив длиной 100_000_000 элементов
 * Метод должен должен циклом for пройти по каждому элементу и посчитать его значение по формуле:
 * array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
 * Засеките время выполнения цикла и выведите его в консоль.
 * Реализация №2:
 * <p>
 * Сделайте то же самое что и в реализации один, только чтобы массив заполняли 4 потока одновременно.
 * То есть первый поток заполняет первую четверть массива, второй - вторую и т.д.
 * И посмотрите насколько быстрее выполнится работа по сравнению с одним потоком.
 */

public class OneThreadRealization {
    public static void main(String[] args) {
        double[] array = new double[1000000000];
        long startTime = System.currentTimeMillis();
        System.out.println("Начало программы" + startTime);
        for (int i = 0; i < 1000000000; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            System.out.println(array[i]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время окончания выполнения программы " + endTime);
        System.out.println("Время выполнения в один поток: " + (endTime - startTime));
    }
}
