package Task_1;

public class Task {
    public static void main(String[] args) {
        Run run1 = new Run();
        Run run2 = new Run();
        Run run3 = new Run();

        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        Thread t3 = new Thread(run3);

        t1.start();
        t2.start();
        t3.start();
    }
}
