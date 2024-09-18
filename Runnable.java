class runnable implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i <= 100; i++) {
                if (i % 10 == 0) {
                    System.out.println(i);
                    Thread.sleep(400);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }
    }

    public static void main(String[] args) {
        runnable runnable1 = new runnable();
        Thread thread1 = new Thread(runnable1);
        thread1.start();
    }
}

