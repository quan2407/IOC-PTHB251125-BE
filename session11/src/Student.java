import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person implements IPerson{
    private String stuId;
    private double averageMark;

    public Student() {
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Student(Date birthday, String name, double averageMark, String stuId) {
        super(birthday, name);
        this.averageMark = averageMark;
        this.stuId = stuId;
    }

    @Override
    public double calculateSalary() {
        return 0;
    }

    @Override
    public double calculateScholarship() {
        if (averageMark >= 9) {
            return 5000000;
        } else if (averageMark >= 8) {
            return 3000000;
        }else if (averageMark >= 7) {
            return 2000000;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "averageMark=" + averageMark +
                ", stuId='" + stuId + '\'' +

                '}';
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        stuId = sc.nextLine();
        System.out.println("Nhập họ tên");
        setName(sc.nextLine());
        System.out.println("Nhập ngày sinh");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    try {
        setBirthday(sdf.parse(sc.nextLine()));
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
        System.out.println("Bla");
    }

    @Override
    public void display() {

    }
}
