import java.util.Random;
import java.util.Scanner;

public class btvngioi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("n phai > 0");
            return;
        }

        String result = generateRandomString(n);
        System.out.println("Chuoi ngau nhien: ");
        System.out.println(result);
    }

    public static String generateRandomString(int n) {
        Random random = new Random();

        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String all = lower + upper + digits;

        StringBuilder sb = new StringBuilder(n);

        if (n < 3) {
            for (int i = 0; i < n; i++) {
                sb.append(all.charAt(random.nextInt(all.length())));
            }
            return sb.toString();
        }

        sb.append(lower.charAt(random.nextInt(lower.length())));
        sb.append(upper.charAt(random.nextInt(upper.length())));
        sb.append(digits.charAt(random.nextInt(digits.length())));

        for (int i = 3; i < n; i++) {
            sb.append(all.charAt(random.nextInt(all.length())));
        }

        char[] arr = sb.toString().toCharArray();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        return new String(arr);
    }
}
