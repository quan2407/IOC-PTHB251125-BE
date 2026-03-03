import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long balance = 1000000;
        final long MIN_BALANCE = 50000;

        while (true) {
            System.out.println("\n===== HỆ THỐNG NGÂN HÀNG =====");
            System.out.println("1. Xem số dư");
            System.out.println("2. Rút tiền");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng (1-3): ");

            String choice = scanner.nextLine();

            if (choice.equals("3")) {
                System.out.println("Cảm ơn quý khách đã sử dụng dịch vụ!");
                break;
            }

            switch (choice) {
                case "1":
                    System.out.println("Số dư hiện tại: " + balance + " VNĐ");
                    break;

                case "2":
                    System.out.print("Nhập số tiền cần rút: ");
                    try {
                        long withdrawAmount = Long.parseLong(scanner.nextLine());

                        if (withdrawAmount <= 0) {
                            System.out.println("Lỗi: Số tiền rút phải lớn hơn 0!");
                        }
                        else if (withdrawAmount > balance) {
                            System.out.println("Lỗi: Số tiền rút vượt quá số dư!");
                        }
                        else if (balance - withdrawAmount < MIN_BALANCE) {
                            System.out.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
                        }
                        else {
                            balance -= withdrawAmount;
                            System.out.println("Rút tiền thành công!");
                            System.out.println("Số tiền đã rút: " + withdrawAmount + " VNĐ");
                            System.out.println("Số dư còn lại: " + balance + " VNĐ");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
                    }
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        }
        scanner.close();
    }
}