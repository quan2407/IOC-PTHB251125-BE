import java.util.Scanner;

public class StringValidator {
    public static boolean isNotBlank(String input) {
        return input != null && input.matches("^(?!\\s*$).+");
    }

    public static boolean isOnlyLetters(String input) {
        return input != null && input.matches("^[a-zA-Z]+$");
    }

    public static boolean isOnlyNumbers(String input) {
        return input != null && input.matches("^\\d+$");
    }

    public static boolean hasNoSpecialChars(String input) {
        return input != null && input.matches("^[a-zA-Z0-9\\s]+$");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi");
        String input = sc.nextLine();
        if (isNotBlank(input) || isOnlyLetters(input) || isOnlyNumbers(input) || hasNoSpecialChars(input)) {
            System.out.println("Chuỗi hợp lệ");
        } else {
            System.out.println("Chuỗi không hợp l");
        }
    }
}
