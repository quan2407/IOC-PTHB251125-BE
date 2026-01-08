import java.util.Scanner;

public class btvnkha2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = Integer.parseInt(sc.nextLine());
        switch (month) {
            case 1,3,5,7,8,10,12: {
                System.out.printf("Tháng %d có 31 ngày",month);
                break;
            }
            case 4,6,9,11: {
                System.out.printf("Tháng %d có 30 ngày",month);
                break;
            }
            case 2: {
                System.out.printf("Tháng %d có 28 hoặc 29 ngày",month);
                break;
            }
            default:
                System.out.println("Tháng không hợp lệ");
        }
    }
}
