import java.util.Scanner;

public class CalculatorMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("---------------MENU-------------");
            System.out.println("1. Tính giai thừa của n");
            System.out.println("2. Tính tổng của n số đầu tiên (vòng lặp)");
            System.out.println("3. Tìm các ước của 1 số n");
            System.out.println("4. thoát");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    System.out.println("Nhập số n: ");
                    int n = Integer.parseInt(sc.nextLine());
                    if (n < 0) {
                        System.err.println("Không có giai thừa số âm");
                    } else if (n == 0) {
                        System.out.println("Giai thừa của 0! là 1");
                    } else {
                        long giaithua = 1;
                        for (int i = 1; i <= n; i++) {
                            giaithua *= i;
                        }
                        System.out.printf("Giai thừa của %d! là %d\n", n, giaithua);
                    }
                    break;

                }
                case 2: {
                    System.out.println("Nhập số n: ");
                    int n = Integer.parseInt(sc.nextLine());
                    if (n < 0) {
                        System.err.println("n không hợp lệ");
                    } else {
                        int tong = 0;
                        for (int i = 1; i <= n; i++) {
                            tong = tong + i;
                        }
                        System.out.printf("Tổng của %d số nguyên là %d\n", n, tong);
                    }
                    break;
                }
                case 3: {
                    System.out.println("Nhập số n: ");
                    int n = Integer.parseInt(sc.nextLine());
                    if (n == 0) {
                        System.err.println("0 không có ước");
                    } else {
                        n = Math.abs(n);
                        System.out.println("uoc cua so n la: ");
                        for (int i = -n; i <= n; i++) {
                            if (i!=0 && n % i == 0) {
                                System.out.print(i + " ");
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("Tạm biệt! ");
                    break;
                }
                default: {
                    System.err.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        } while (choice != 4);
    }
}
