import java.util.Date;
import java.util.Scanner;

public class Student extends Person{
    private String id;
    private String className;
    private String schoolName;

    public Student() {
        super();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student(String quan, boolean b, String s) {
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Student(String name, Boolean gender, Date birthday, String address, String className, String id, String schoolName) {
        super(name, gender, birthday, address);
        this.className = className;
        this.id = id;
        this.schoolName = schoolName;
    }

    @Override
    public void input() {
        System.out.println("Nhập mã sinh viên");
        Scanner sc = new Scanner(System.in);
        id = sc.nextLine();
        super.input();
        System.out.println("Nhập lớp");
        className = sc.nextLine();
        System.out.println("Nhập trường");
        schoolName = sc.nextLine();
    }

    @Override
    public void display() {
        System.out.println("\tID: " + id);
        super.display();
        System.out.println("\tLớp học" + className);
        System.out.println("\tTrường: " + schoolName);
    }
}
