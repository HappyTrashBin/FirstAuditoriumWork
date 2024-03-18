package Task_3;

import java.util.Random;

public class Task {
    public static void main(String[] args) throws InterruptedException {
        int NUMBER_OF_CITIZENS = 100;
        Thread[] citizens = new Thread[NUMBER_OF_CITIZENS];
        Category[] categories = Category.values();

        for (int i = 0; i < NUMBER_OF_CITIZENS; i++) {
            citizens[i] = new Thread(new Citizen(categories[new Random().nextInt(categories.length)]));
            citizens[i].start();
        }
        for (int i = 0; i < NUMBER_OF_CITIZENS; i++) {
            citizens[i].join();
        }
        Windows.printStatistics();
    }
}