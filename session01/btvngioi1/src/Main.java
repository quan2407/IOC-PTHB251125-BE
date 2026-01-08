import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tử 1(a): ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập mẫu 1(b): ");
        int b = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tử 2(c): ");
        int c = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập mẫu 2(d): ");
        int d = Integer.parseInt(sc.nextLine());
        System.out.println("Kết quả: " + (a*d + b*c) + "/" + (b*d));
    }
}