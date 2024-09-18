class thread extends Thread {
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
            System.out.println("ошибка");
        }
    }

    public static void main(String[] args) {
        thread thread1 = new thread();
        thread1.start();
    }
}