import java.util.Scanner;
import java.util.regex.Pattern;

public class QuanLyNguoiDung {
    static String hoTen = "";
    static String email = "";
    static String soDienThoai = "";
    static String matKhau = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("\n**************** QUẢN LÝ NGƯỜI DÙNG ****************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập họ và tên: ");
                    hoTen = scanner.nextLine();
                    System.out.print("Nhập email: ");
                    email = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    soDienThoai = scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    matKhau = scanner.nextLine();
                    System.out.println("=> Đã lưu thông tin tạm thời.");
                    break;

                case 2:
                    if (hoTen.isEmpty()) {
                        System.out.println("Vui lòng nhập thông tin ở mục 1 trước!");
                    } else {
                        hoTen = chuanHoaHoTen(hoTen);
                        System.out.println("Họ tên sau chuẩn hóa: " + hoTen);
                    }
                    break;

                case 3:
                    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
                    if (Pattern.matches(emailRegex, email)) {
                        System.out.println("Email '" + email + "' hợp lệ.");
                    } else {
                        System.out.println("Email không hợp lệ!");
                    }
                    break;

                case 4:
                    String sdtRegex = "^0\\d{9}$";
                    if (Pattern.matches(sdtRegex, soDienThoai)) {
                        System.out.println("Số điện thoại hợp lệ.");
                    } else {
                        System.out.println("Số điện thoại không đúng định dạng VN (10 số, bắt đầu bằng 0).");
                    }
                    break;

                case 5:
                    String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
                    if (Pattern.matches(passwordRegex, matKhau)) {
                        System.out.println("Mật khẩu mạnh và hợp lệ.");
                    } else {
                        System.out.println("Mật khẩu yếu! Cần ít nhất 8 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt.");
                    }
                    break;

                case 6:
                    System.out.println("Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 6);

        scanner.close();
    }

    public static String chuanHoaHoTen(String str) {
        str = str.trim().replaceAll("\\s+", " ");
        String[] words = str.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                sb.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1)).append(" ");
            }
        }
        return sb.toString().trim();
    }
}