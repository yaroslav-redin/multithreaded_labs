public class MultiThreadTimer {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread timer = new Thread(() -> {
            int seconds = 0;
            while (true) {
                try {
                    System.out.println(seconds + " сек.");
                    Thread.sleep(1000);
                    seconds++;
                    synchronized (lock) {
                        lock.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread seconds5 = new Thread(() -> {
            int seconds = 0;
            while (true) {
                try {
                    synchronized (lock) {
                        lock.wait();
                    }
                    seconds++;
                    if (seconds % 5 == 0) {
                        System.out.println("прошло " + seconds + " сек.(сработал счётчик на 5 сек.)");

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread seconds7 = new Thread(() -> {
            int seconds = 0;
            while (true) {
                try {
                    synchronized (lock) {
                        lock.wait();
                    }
                    seconds++;
                    if (seconds % 7 == 0) {
                        System.out.println("прошло " + seconds + " сек.(сработал счётчик на 7 сек.)");

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        timer.start();
        seconds5.start();
        seconds7.start();
    }
}