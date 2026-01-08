import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final double PI = 3.14;

        double radius = input.nextDouble();
        double area = PI * radius * radius;

        System.out.println("Diện tích : " + area);
    }
}
