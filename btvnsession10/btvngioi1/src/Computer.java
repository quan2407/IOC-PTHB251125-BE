public class Computer {
    public double calculatePrice(double price) {
        System.out.println("[Using basePrice only]");
        return price;
    }
    public double calculatePrice(double price, double tax) {
        System.out.println("[Using basePrice + tax]");
        return price+tax;
    }
    public double calculatePrice(double price, double tax, double discount) {
        System.out.println("[Using basePrice + tax + discount]");
        return price+tax+discount;
    }
}
