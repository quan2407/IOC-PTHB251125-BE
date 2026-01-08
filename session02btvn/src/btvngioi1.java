import java.util.Scanner;

public class btvngioi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số N: ");
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        while(n>0){
            sum = sum + n%10;
            n/=10;
        }
        System.out.println("Tổng các chữ số là: " + sum);
    }
}
