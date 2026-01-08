import java.util.Scanner;

public class AdvanceCalculator {
    public static void main(String[] args) {
        System.out.println("--------------MENU-----------");
        System.out.println("1. Tính tổng của n số tự nhiên đầu tiên (n*n+1)/2 (n nhập từ bàn phím");
        System.out.println("2. Tính thương của 2 số nguyên a,b (xét trường hợp b=0 thì in lỗi đỏ)");
        Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
            {
                System.out.print("Nhập số lượng số tự nhiên đầu tiên: ");
                int n = Integer.parseInt(sc.nextLine());
                System.out.println("Tổng của " + n + " số tự nhiên là: " + (n*(n+1))/2);
                break;
            }
            case 2:
            {
                System.out.print("Nhập số a: ");
                int a = Integer.parseInt(sc.nextLine());
                System.out.print("Nhập số b: ");
                int b = Integer.parseInt(sc.nextLine());
                if (b == 0){
                    System.err.print("b không được bằng 0");
                    break;
                }
                double result = (double) a / b;
                System.out.println("Kết quả của "+ a + "/" + b+" là: " + result);
                break;
            }
            default:
            {
                System.err.println("Nhập không hợp lệ");
            }

        }
    }
}
