public class ShoppingCart {
    public static double calculateTotal(double[] prices, String customerType){
        double total = 0;
        for (double price: prices) {
            total += price;
        }

        switch (customerType) {
            case "REGULAR":
                break;
            case "PREMIUM":
                total = total * 0.9;
                break;
            case "VIP":
                total = total * 0.8;
                break;
            default:
                System.out.println("Invalid customer type.");
        }
        return total;
    }
    public static double findMostExpensive(double[] prices) {
        double max = prices[0];
        for (double price : prices) {
            if (price > max) max = price;
        }
        return max;
    }
    public static int countExpensiveItems(double[] prices, double threshold){
        int count = 0;
        for (double price : prices) {
            if (price > threshold) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        double[] cart = {25.99, 45.50, 12.99, 89.99, 15.75};
        System.out.println("Regular customer total: $" + calculateTotal(cart,
                "REGULAR"));
        System.out.println("Premium customer total: $" + calculateTotal(cart,
                "PREMIUM"));
        System.out.println("VIP customer total: $" + calculateTotal(cart,
                "VIP"));
        System.out.println("Most expensive item: "+findMostExpensive(cart));
        System.out.println("Items over $30: "+countExpensiveItems(cart,30));

    }
}
