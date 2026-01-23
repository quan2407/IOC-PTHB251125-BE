//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Computer myCom = new Computer();

        double base = 1000.0;
        double tax = 100.0;
        double discount = 50.0;

        double res1 = myCom.calculatePrice(base);
        System.out.println("Final Price = " + res1);
        System.out.println();

        double res2 = myCom.calculatePrice(base, tax);
        System.out.println("Final Price = " + res2);
        System.out.println();

        double res3 = myCom.calculatePrice(base, tax, discount);
        System.out.println("Final Price = " + res3);
    }
}