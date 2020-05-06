package my.example;

public class Issue8 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(Issue8::ThreadOne);
        Thread t2 = new Thread(Issue8::ThreadTwo);

        t1.start();
        t2.start();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++)


            Thread.sleep(500);

        long endTime = System.currentTimeMillis();
        System.out.printf("Time of execution = %d ms\n", (endTime - startTime));
    }

    public static void ThreadOne() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread 1 = " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void ThreadTwo() {
        for (int j = 2; j < 9; j += 2) {
            if (j % 2 == 0) {
                System.out.println("Thread 2 = " + j);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
