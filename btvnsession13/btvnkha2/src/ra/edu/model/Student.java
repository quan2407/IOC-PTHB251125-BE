package ra.edu.model;

import java.util.Scanner;

public class Student implements IBaseModel {
    private int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập id sinh viên: ");
        this.id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên sinh viên: ");
        this.name = sc.nextLine();
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %-5d | Tên: %-20s \n",
                this.id, this.name);
    }
}
