package ra.business;

import ra.entity.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductBusiness {
    private List<Product> listProducts = new ArrayList<>();

    public void addProduct(Scanner scanner) {
        System.out.print("Nhập số lượng sản phẩm muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin cho sản phẩm thứ " + (i + 1) + ":");
            Product newProduct = new Product();

            while (true) {
                newProduct.inputData(scanner);
                if (isNameExist(newProduct.getName())) {
                    System.err.println("Lỗi: Tên sản phẩm đã tồn tại! Vui lòng nhập lại.");
                } else {
                    break;
                }
            }
            listProducts.add(newProduct);
        }
        System.out.println("Thêm mới thành công!");
    }

    private boolean isNameExist(String name) {
        return listProducts.stream().anyMatch(p -> p.getName().equalsIgnoreCase(name));
    }

    public void displayProducts() {
        if (listProducts.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        System.out.println("--- DANH SÁCH SẢN PHẨM ---");
        for (Product p : listProducts) {
            System.out.println(p.toString());
        }
    }

    public void updateProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findIndexById(id);

        if (index != -1) {
            System.out.println("Đã tìm thấy sản phẩm. Mời bạn nhập thông tin mới:");
            listProducts.get(index).inputData(scanner);
            System.out.println("Cập nhật thành công!");
        } else {
            System.err.println("Không tìm thấy mã sản phẩm " + id);
        }
    }

    public void deleteProduct(Scanner scanner) {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findIndexById(id);

        if (index != -1) {
            listProducts.remove(index);
            System.out.println("Xóa thành công!");
        } else {
            System.err.println("Không tìm thấy mã sản phẩm để xóa!");
        }
    }

    public void searchByName(Scanner scanner) {
        System.out.print("Nhập từ khóa tìm kiếm: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Product p : listProducts) {
            if (p.getName().toLowerCase().contains(keyword)) {
                System.out.println(p.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sản phẩm nào chứa từ khóa: " + keyword);
    }

    public void sortByPriceAsc() {
        Collections.sort(listProducts, (p1, p2) -> Float.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("Đã sắp xếp theo giá tăng dần.");
        displayProducts();
    }

    public void sortByQuantityDesc() {
        Collections.sort(listProducts, (p1, p2) -> Integer.compare(p2.getQuantity(), p1.getQuantity()));
        System.out.println("Đã sắp xếp theo số lượng giảm dần.");
        displayProducts();
    }

    private int findIndexById(int id) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}