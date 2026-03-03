import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MovieManagement management = new MovieManagement();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        handleInsert();
                        break;
                    case "2":
                        management.listMovies();
                        break;
                    case "3":
                        handleUpdate();
                        break;
                    case "4":
                        handleDelete();
                        break;
                    case "5":
                        System.out.println("Đang thoát ứng dụng...");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 1-5.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Bạn phải nhập số cho ID và Năm phát hành!");
            } catch (IllegalArgumentException e) {
                System.err.println("Lỗi: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Đã xảy ra lỗi không xác định!");
                e.printStackTrace();
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n***********************************");
        System.out.println("* HỆ THỐNG QUẢN LÝ PHIM (POSTGRE) *");
        System.out.println("***********************************");
        System.out.println("1. Thêm phim mới");
        System.out.println("2. Hiển thị danh sách phim");
        System.out.println("3. Cập nhật thông tin phim");
        System.out.println("4. Xóa phim theo ID");
        System.out.println("5. Thoát");
        System.out.print("Lựa chọn của bạn: ");
    }

    private static void handleInsert() {
        System.out.print("Nhập tiêu đề phim: ");
        String title = validateNotEmpty(scanner.nextLine());
        System.out.print("Nhập đạo diễn: ");
        String director = validateNotEmpty(scanner.nextLine());
        System.out.print("Nhập năm phát hành: ");
        int year = Integer.parseInt(scanner.nextLine());
        management.addMovie(title, director, year);
    }

    private static void handleUpdate() {
        System.out.print("Nhập ID phim cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Tiêu đề mới: ");
        String title = validateNotEmpty(scanner.nextLine());
        System.out.print("Đạo diễn mới: ");
        String director = validateNotEmpty(scanner.nextLine());
        System.out.print("Năm phát hành mới: ");
        int year = Integer.parseInt(scanner.nextLine());
        management.updateMovie(id, title, director, year);
    }

    private static void handleDelete() {
        System.out.print("Nhập ID phim muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            management.deleteMovie(id);
        }
    }

    private static String validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Dữ liệu không được để trống!");
        }
        return input.trim();
    }
}