package Task_2;

import java.util.concurrent.CopyOnWriteArrayList;

public class Task {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Integer> sharedList = new CopyOnWriteArrayList<>();
        Thread readerThread = new Thread(new toRead(sharedList));
        Thread writerThread = new Thread(new toWrite(sharedList));

        writerThread.start();
        writerThread.join();
        readerThread.start();
    }
}

