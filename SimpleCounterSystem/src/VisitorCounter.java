public class VisitorCounter {
    private static int totalVisitors = 0;
    private int sessionVisits;
    private String visitorName;

    public VisitorCounter(String visitorName) {
        this.visitorName = visitorName;
        this.sessionVisits = 0;
        totalVisitors++;
    }
    public void recordVisit(){
        sessionVisits++;
        System.out.println(visitorName + " visited. Session visits: " + sessionVisits);
    }
    public static void displayTotalVisitors(){
        System.out.println("Total visitors today: " + totalVisitors);
    }

    public static int getTotalVisitors() {
        return totalVisitors;
    }
    public static void main(String[] args) {
        VisitorCounter visitor1 = new VisitorCounter("Shahad");
        VisitorCounter visitor2 = new VisitorCounter("Ali");
        VisitorCounter visitor3 = new VisitorCounter("Raghad");
        visitor1.recordVisit();
        visitor2.recordVisit();
        visitor3.recordVisit();
        displayTotalVisitors();
    }
}
