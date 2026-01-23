import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Person {
    private String name;
    private Boolean gender;
    private Date birthday;
    private String address;

    public Person() {
    }

    public Person(String name, Boolean gender, Date birthday, String address) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void input()  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập họ tên");
        name = sc.nextLine();
        System.out.println("Nhập giới tính");
        gender = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Nhập ngày sinh");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            birthday = sdf.parse(sc.nextLine());
        } catch (ParseException e) {
            System.out.println("Có lỗi: " + e.getMessage());
        }
        System.out.println("Nhập quê quán");
        address = sc.nextLine();
    }
    public void display(){
        System.out.println("\tName: " + name);
        System.out.println("\tGender: " + (gender?"Nam":"Nữ"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\tBirthday: " + sdf.format(birthday));
        System.out.println("\tAddress: " + address);
    }
}
