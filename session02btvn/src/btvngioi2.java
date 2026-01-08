import java.util.Scanner;

public class btvngioi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập cạnh 1: ");
        int a = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập cạnh 2: ");
        int b = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập cạnh 3: ");
        int c = Integer.parseInt(sc.nextLine());

        if (a + b <= c || a + c <= b || b + c <= a) {
            System.err.println("Ba cạnh không tạo thành tam giác");
            return;
        }

        if (a == b && b == c) {
            System.out.println("Tam giác đều");
        }
        else if (a * a == b * b + c * c ||
                b * b == a * a + c * c ||
                c * c == a * a + b * b) {
            System.out.println("Tam giác vuông");
        }
        else if (a == b || a == c || b == c) {
            System.out.println("Tam giác cân");
        }
        else {
            System.out.println("Tam giác thường");
        }
    }
}
