import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private String description;
    private double price;
    private int stock;
    private boolean status; // true: hiện, false: ẩn

    public Product() {
    }

    public Product(String productId, String productName, String description, double price, int stock, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm: ");
        this.productId = sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        this.productName = sc.nextLine();
        System.out.print("Nhập mô tả: ");
        this.description = sc.nextLine();
        System.out.print("Nhập giá tiền: ");
        this.price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập tồn kho: ");
        this.stock = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập trạng thái (true - Hiện / false - Ẩn): ");
        this.status = Boolean.parseBoolean(sc.nextLine());
    }

    public void displayInfo() {
        System.out.println("------------------------------------");
        System.out.println("Mã SP: " + this.productId);
        System.out.println("Tên SP: " + this.productName);
        System.out.println("Mô tả: " + this.description);
        System.out.println("Giá: " + this.price);
        System.out.println("Tồn kho: " + this.stock);
        System.out.println("Trạng thái: " + (this.status ? "Đang hiện" : "Đang ẩn"));
        System.out.println("------------------------------------");
    }
}