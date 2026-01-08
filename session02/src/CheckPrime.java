import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        boolean isPrime = true;
        if (n < 2) {
            isPrime = false;
        } else  {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    count++;
                }
            }
            if (count > 2) {
                isPrime = false;
            }
        }
        if (isPrime) {
            System.out.println("Prime ");
        }  else {
            System.out.println("Not Prime ");
        }
    }
}
