import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số thứ nhất (firstNumber): ");
        int firstNumber = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số thứ hai (secondNumber): ");
        int secondNumber = Integer.parseInt(sc.nextLine());
        System.out.println("--- Kết quả ---");
        System.out.println("firstNumber = " + firstNumber);
        System.out.println("secondNumber = " + secondNumber);
        int sum = firstNumber + secondNumber;
        System.out.println("Tổng = " + sum);
        int sub = firstNumber - secondNumber;
        System.out.println("Hiệu = " + sub);
        int mul = firstNumber * secondNumber;
        System.out.println("Tích = " + mul);
        int div = firstNumber / secondNumber;
        System.out.println("Thương = " + div);
        int mod = firstNumber % secondNumber;
        System.out.println("Phần dư = " + mod);
    }
}