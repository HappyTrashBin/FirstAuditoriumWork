package Task_2;

import java.util.concurrent.CopyOnWriteArrayList;

class toRead implements Runnable{
    private CopyOnWriteArrayList<Integer> listOfNumbers;
    public toRead(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }
    public void run() {
        listOfNumbers.forEach((number) -> {
            System.out.println(number);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
