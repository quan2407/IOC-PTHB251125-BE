package ra.entity;

import java.util.Scanner;

public class Product {
    private static int count = 1;
    private int id;
    private String name;
    private float price;
    private  String category;
    private int quantity;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(String category, String name, float price, int quantity) {
        this.category = category;
        this.id = count++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
    public void inputData(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên sản phẩm (10-50 ký tự): ");
            this.name = scanner.nextLine();
            if (this.name.length() >= 10 && this.name.length() <= 50) {
                break;
            }
            System.err.println("Tên sản phẩm không hợp lệ, vui lòng nhập lại!");
        }
        while (true) {
            System.out.print("Nhập giá sản phẩm: ");
            try {
                this.price = Float.parseFloat(scanner.nextLine());
                if (this.price > 0) break;
                else System.err.println("Giá phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số thực hợp lệ!");
            }
        }

        while (true) {
            System.out.print("Nhập loại sản phẩm (tối đa 200 ký tự): ");
            this.category = scanner.nextLine();
            if (this.category.length() <= 200 && !this.category.isEmpty()) break;
            System.err.println("Loại sản phẩm không hợp lệ!");
        }

        while (true) {
            System.out.print("Nhập số lượng tồn kho: ");
            try {
                this.quantity = Integer.parseInt(scanner.nextLine());
                if (this.quantity >= 0) break;
                else System.err.println("Số lượng phải >= 0!");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }
}
