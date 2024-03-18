package Task_3;

public class Windows {
    private static float servedYoung = 0;
    private static float servedOld = 0;
    private static float servedBusiness = 0;
    private static int unservedYoung = 0;
    private static int unservedOld = 0;
    private static int unservedBusiness = 0;
    private boolean freeWindow = true;
    private int suitableCategory;
    private static Windows[] windows = {
            new Windows(0),
            new Windows(1),
            new Windows(2)
    };
    private Windows(int suitableCategory) {
        this.suitableCategory = suitableCategory;
    }
    private void addServedCitizen(Citizen citizen) {
        if (citizen.getCategory().ordinal() == 0) {servedYoung += 1;}
        if (citizen.getCategory().ordinal() == 1) {servedOld += 1;}
        if (citizen.getCategory().ordinal() == 2) {servedBusiness += 1;}
    }
    private void addUnservedCitizen(Citizen citizen) {
        if (citizen.getCategory().ordinal() == 0) {unservedYoung += 1;}
        if (citizen.getCategory().ordinal() == 1) {unservedOld += 1;}
        if (citizen.getCategory().ordinal() == 2) {unservedBusiness += 1;}
    }
    public synchronized void serveCitizen(Citizen citizen) {
        if (freeWindow && (suitableCategory == 0 || suitableCategory == citizen.getCategory().ordinal())) {
            freeWindow = false;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                freeWindow = true;
            }
            addServedCitizen(citizen);
        } else {
            addUnservedCitizen(citizen);
        }
    }
    public static Windows[] getWindows() {
        return windows;
    }
    private static float twoAndOneRound(float number) {
        return (float) (Math.round(number*1000.0)/10.0);
    }
    public static void printStatistics() {
        System.out.println("Молодёжь - не обслужено " + twoAndOneRound(unservedYoung/(servedYoung+unservedYoung)) + "%");
        System.out.println("Пожилые - не обслужено " + twoAndOneRound(unservedOld/(servedOld+unservedOld)) + "%");
        System.out.println("Бизнесмены - не обслужено " + twoAndOneRound(unservedBusiness/(servedBusiness+unservedBusiness)) + "%");
    }
}