import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> listString = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập chuỗi (gõ 'exit' để kết thúc): ");
            String inputString = scanner.nextLine();

            if (inputString.trim().equalsIgnoreCase("exit")) {
                break;
            }
            listString.add(inputString);
        }

        List<Integer> validIntList = new ArrayList<>();
        int invalidCount = 0;

        for (String str : listString) {
            try {
                int value = Integer.parseInt(str.trim());
                validIntList.add(value);
            } catch (NumberFormatException e) {
                invalidCount++;
            }
        }

        System.out.println("\n--- Kết quả ---");
        System.out.println("Tổng số chuỗi đã nhập: " + listString.size());
        System.out.println("Số lượng số hợp lệ: " + validIntList.size());
        System.out.println("Số lượng không hợp lệ: " + invalidCount);

        System.out.println("Danh sách các số hợp lệ:");
        for (Integer num : validIntList) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}