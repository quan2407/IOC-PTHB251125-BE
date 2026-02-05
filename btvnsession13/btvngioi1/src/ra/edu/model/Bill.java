package ra.edu.model;

import java.util.Scanner;

public class Bill implements IBaseModel {
    private int id;
    private String billCode;
    private double price;

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Bill() {
    }

    public Bill(String billCode, int id, double price) {
        this.billCode = billCode;
        this.id = id;
        this.price = price;
    }

    @Override
    public void inputData(Scanner sc) {
        // Nhập mã hóa đơn
        System.out.print("Nhập mã hóa đơn: ");
        this.billCode = sc.nextLine();

        // Nhập giá tiền
        while (true) {
            try {
                System.out.print("Nhập số tiền: ");
                this.price = Double.parseDouble(sc.nextLine());
                if (this.price < 0) {
                    System.err.println("Giá tiền không được âm. Vui lòng nhập lại!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Giá tiền phải là một con số!");
            }
        }

    }

    @Override
    public void displayData() {
        System.out.printf("ID: %-5d | Mã hóa đơn: %-20s | Gía: %-25s\n",
                this.id, this.billCode, this.price);
    }

}
