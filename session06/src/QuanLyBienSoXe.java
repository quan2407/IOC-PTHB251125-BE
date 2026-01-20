import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class QuanLyBienSoXe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> danhSachBienSo = new ArrayList<>();
        int luaChon;

        do {
            System.out.println("\n**************** QUẢN LÝ BIỂN SỐ XE ****************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập số lượng biển số muốn thêm: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập biển số thứ " + (i + 1) + " (VD: 30F-123.45): ");
                        String bienSo = scanner.nextLine().toUpperCase();
                        // Regex kiểm tra định dạng cơ bản: 2 số - 1 chữ - 5 số (có dấu chấm)
                        if (Pattern.matches("^\\d{2}[A-Z]-\\d{3}\\.\\d{2}$", bienSo)) {
                            danhSachBienSo.add(bienSo);
                        } else {
                            System.out.println("Định dạng sai! Vui lòng nhập đúng mẫu 30F-123.45");
                            i--; // Cho phép nhập lại lượt này
                        }
                    }
                    break;

                case 2:
                    if (danhSachBienSo.isEmpty()) {
                        System.out.println("Danh sách đang trống.");
                    } else {
                        System.out.println("--- Danh sách biển số xe ---");
                        for (String bs : danhSachBienSo) {
                            System.out.println(bs);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập biển số chính xác cần tìm: ");
                    String timKiem = scanner.nextLine().toUpperCase();
                    if (danhSachBienSo.contains(timKiem)) {
                        System.out.println("Tìm thấy biển số " + timKiem + " trong danh sách.");
                    } else {
                        System.out.println("Không tìm thấy biển số này.");
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã tỉnh cần tìm (VD: 29, 30, 51...): ");
                    String maTinh = scanner.nextLine();
                    System.out.println("Kết quả lọc theo mã tỉnh " + maTinh + ":");
                    boolean found = false;
                    for (String bs : danhSachBienSo) {
                        // Kiểm tra nếu biển số bắt đầu bằng mã tỉnh nhập vào
                        if (bs.startsWith(maTinh)) {
                            System.out.println(bs);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Không có biển số nào thuộc tỉnh này.");
                    break;

                case 5:
                    Collections.sort(danhSachBienSo);
                    System.out.println("Đã sắp xếp danh sách tăng dần.");
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
}