import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("width = ");
        float width = Float.parseFloat(sc.nextLine());
        System.out.print("height = ");
        float height = Float.parseFloat(sc.nextLine());
        System.out.println("Diện tích : " + width * height);
        System.out.println("Chu vi : " + 2 * (width + height));
    }
}