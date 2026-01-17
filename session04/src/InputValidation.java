import java.util.Scanner;

public class InputValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập chuỗi:");
            String input = sc.nextLine();
            if (input.isBlank()){
                System.out.println("Chuỗi trống vui lòng nhập lại");
            } else if (input.length()<6){
                System.out.println("Chuỗi ít hơn 6 kí tự, vui lòng nhập lại");
            } else {
                System.out.println("Chuỗi vừa nhập là " + input);
                break;
            }

        }

    }
}

