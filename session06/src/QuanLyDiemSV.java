import java.util.Arrays;
import java.util.Scanner;

public class QuanLyDiemSV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int luaChon;
        double[] diemSinhvien = null;

        do {
            // Hiển thị Menu
            System.out.println("\n****************QUẢN LÝ ĐIỂM SV****************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            // Đọc lựa chọn của người dùng
            luaChon = scanner.nextInt();

            // Xử lý lựa chọn bằng switch-case
            switch (luaChon) {
                case 1:
                    if (diemSinhvien != null) {
                        System.out.print("Dữ liệu đã tồn tại. Bạn có muốn nhập mới không? (Y/N): ");
                        scanner.nextLine();
                        String confirm = scanner.nextLine();
                        if (confirm.equalsIgnoreCase("N")) {
                            break;
                        }
                    }

                    System.out.println("--- Nhập danh sách điểm ---");
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n = Integer.parseInt(scanner.nextLine());

                    diemSinhvien = new double[n];

                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập điểm sinh viên thứ " + (i + 1) + ": ");
                        diemSinhvien[i] = Double.parseDouble(scanner.nextLine());
                    }
                    break;
                case 2:
                    if (diemSinhvien == null) {
                        System.out.println("Không tồn tại dữ liệu điểm vui lòng nhập lại");
                        break;
                    }
                    System.out.println("Thực thi: In danh sách điểm...");
                    for (int i = 0; i < diemSinhvien.length; i++) {
                        System.out.println("Điểm sinh viên thứ " + (i + 1) + ": " + diemSinhvien[i]);
                    }
                    break;
                case 3:
                    if (diemSinhvien == null) {
                        System.out.println("Không tồn tại dữ liệu điểm vui lòng nhập lại");
                        break;
                    }
                    System.out.println("Thực thi: Tính điểm trung bình...");
                    double sum = 0;
                    for (int i = 0; i < diemSinhvien.length; i++) {
                        sum += diemSinhvien[i];
                    }
                    System.out.println("Điểm trung bình của sinh viên " + (sum / diemSinhvien.length));
                    break;
                case 4:
                    if (diemSinhvien == null) {
                        System.out.println("Không tồn tại dữ liệu điểm vui lòng nhập lại");
                        break;
                    }
                    System.out.println("Thực thi: Tìm điểm Max/Min...");
                    double max = diemSinhvien[0];
                    double min = diemSinhvien[0];
                    for (int i = 1; i < diemSinhvien.length; i++) {
                        if (diemSinhvien[i] > max) {
                            max = diemSinhvien[i];
                        }
                        if (diemSinhvien[i] < min) {
                            min = diemSinhvien[i];
                        }
                    }
                    System.out.println("Điểm cao nhất : " + max);
                    System.out.println("Điểm thấp nhất : " + min);
                    break;
                case 5:
                    if (diemSinhvien == null) {
                        System.out.println("Không tồn tại dữ liệu điểm vui lòng nhập lại");
                        break;
                    }
                    System.out.println("Thực thi: Đếm số lượng đạt/trượt...");
                    int sinhVienTruot = 0;
                    int sinhVienDat = 0;
                    for (int i = 0; i < diemSinhvien.length; i++) {
                        if (diemSinhvien[i] < 5) {
                            sinhVienTruot++;
                        } else {
                            sinhVienDat++;
                        }
                    }
                    System.out.println("Số lượng sinh viên trượt : " + sinhVienTruot);
                    System.out.println("Số lượng sinh viên đạt : " + sinhVienDat);
                    break;
                case 6:
                    if (diemSinhvien == null) {
                        System.out.println("Không tồn tại dữ liệu điểm vui lòng nhập lại");
                        break;
                    }
                    System.out.println("Thực thi: Sắp xếp điểm tăng dần...");
                    for (int i = 0; i < diemSinhvien.length-1; i++) {
                        for (int j = i+1; j < diemSinhvien.length-i-1; j++) {
                            if (diemSinhvien[j] > diemSinhvien[j+1]) {
                                double temp = diemSinhvien[j];
                                diemSinhvien[j] = diemSinhvien[j+1];
                                diemSinhvien[j+1] = temp;
                            }
                        }
                    }
                    System.out.println("Danh sách sau khi sắp xếp:");
                    System.out.println(Arrays.toString(diemSinhvien));
                    break;
                case 7:
                    if (diemSinhvien == null) {
                        System.out.println("Không tồn tại dữ liệu điểm vui lòng nhập lại");
                        break;
                    }
                    System.out.println("Thực thi: Thống kê sinh viên giỏi/xuất sắc...");
                    int soLuongSinhVienGioiVaXuatSac = 0;
                    for (int i = 0; i < diemSinhvien.length; i++) {
                        if (diemSinhvien[i] >=8){
                            soLuongSinhVienGioiVaXuatSac++;
                        }
                    }
                    System.out.println("Số lượng sinh viên giỏi và xuất sắc " + soLuongSinhVienGioiVaXuatSac);
                    break;
                case 8:
                    System.out.println("Đang thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại (1-8).");
                    break;
            }

        } while (luaChon != 8);

        scanner.close();
    }
}