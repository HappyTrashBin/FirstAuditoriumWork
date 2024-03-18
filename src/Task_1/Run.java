package Task_1;

class Run implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getId());
    }
}
