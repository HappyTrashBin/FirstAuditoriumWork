package Task_3;

import java.util.Random;

public class Citizen implements Runnable {
    private static final Windows[] windows = Windows.getWindows();
    private Category category;
    public Citizen(Category category) {
        this.category = category;
    }
    public void run() {
        int windowNumber = new Random().nextInt(windows.length);
        Windows neededWindow = windows[windowNumber];
        neededWindow.serveCitizen(this);
    }
    public Category getCategory() {
        return category;
    }
}
