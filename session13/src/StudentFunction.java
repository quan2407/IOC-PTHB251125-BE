import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentFunction {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Nguyễn Văn A", "0901234567", true));
        students.add(new Student(2, "Trần Thị B", "0907654321", false));
        students.add(new Student(3, "Lê Văn C", "0988888888", true));
        System.out.println(students.get(1));
        students.get(1).setName("Hồ Đức Minh");
        students.remove(0);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vị trí muốn thêm");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice < 0 || choice > students.size()) {
            System.out.println("Vị trí không hợp lệ!");
        } else {
            Student newStudent = new Student(4, "Hoàng Văn D", "0911223344", true);

            students.add(choice, newStudent);

            System.out.println("Đã thêm thành công!");
        }
        for (Student student : students) {
            if (student.getName().toLowerCase().contains("văn")){
                System.out.println(student);
            }
        }
    }

}
