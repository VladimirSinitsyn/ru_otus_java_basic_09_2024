package homework14.threads;

public class MultyThreadRealization {
    public static void main(String[] args) throws InterruptedException {
        double[] array = new double[1000000000];
        Thread[] threads = new Thread[4];
        long startTime = System.currentTimeMillis();
        System.out.println("Начало программы" + startTime);

        for (int t = 0; t < threads.length; t++) {
            int threadId = t;
            threads[threadId] = new Thread(() -> {

                for (int i = threadId * 250000; i < (threadId + 1) * 250000; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            });

            threads[t].start();

        }
        for (Thread thread : threads) {
            thread.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время окончания выполнения программы " + endTime);
        System.out.println("Время выполнения в 4 потока: " + (endTime - startTime));
    }

}




