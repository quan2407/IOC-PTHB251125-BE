import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Đưa danh sách ra ngoài làm biến static để các hàm khác có thể dùng chung
    private static List<Product> products = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Thêm dữ liệu mẫu để test
        products.add(new Product(1, "iPhone 15", 2000));

        while (true) {
            System.out.println("""
                    ----------------MENU----------------
                    1. In danh sách sản phẩm
                    2. Thêm mới 1 sản phẩm
                    3. Xóa 1 sản phẩm
                    4. Tìm kiếm sản phẩm theo tên
                    5. Thoát
                    """);
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    showProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Hàm lấy ID lớn nhất để tự động tăng ID khi thêm mới
    private static int getMaxID() {
        int maxID = 0;
        for (Product p : products) {
            if (p.getId() > maxID) {
                maxID = p.getId();
            }
        }
        return maxID;
    }

    private static void showProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách trống!");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }

    private static void addProduct() {
        int newId = getMaxID() + 1;
        System.out.print("Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        // Bạn có thể nhập thêm giá, trạng thái ở đây...
        products.add(new Product(newId, name, 0));
        System.out.println("Thêm thành công!");
    }

    private static void deleteProduct() {
        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        products.removeIf(p -> p.getId() == id);
        System.out.println("Đã thực hiện xóa!");
    }

    private static void searchProduct() {
        System.out.print("Nhập tên cần tìm: ");
        String keyword = sc.nextLine().toLowerCase();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(keyword)) {
                System.out.println(p);
            }
        }
    }
}