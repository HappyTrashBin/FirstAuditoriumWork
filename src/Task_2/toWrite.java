package Task_2;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class toWrite implements Runnable{
    private CopyOnWriteArrayList<Integer> listOfNumbers;
    public toWrite(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }
    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество чисел");
        int count = scan.nextInt();
        while (count > 0) {
            listOfNumbers.add((int) (count*(Math.pow(-1,count))));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count -= 1;
        }
    }
}
