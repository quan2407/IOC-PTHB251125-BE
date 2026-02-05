package ra.edu.model;

import java.util.Scanner;

public class User implements IBaseModel {
    private int id;
    private String name;
    private String email;
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(String email, int id, String name, String phone) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.print("Nhập tên người dùng: ");
        this.name = sc.nextLine();

        System.out.print("Nhập email: ");
        this.email = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        this.phone = sc.nextLine();
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %-5d | Tên: %-20s | Email: %-25s | SĐT: %-15s \n",
                this.id, this.name, this.email, this.phone);
    }

    public User() {
    }
}
