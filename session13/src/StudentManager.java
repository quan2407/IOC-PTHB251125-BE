import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    public void showListStudents(){
        for(Student s: students){
            System.out.println(s);
        }
    }
    public void addStudent(Scanner sc){
        Student student = new Student();
        student.setId(getMaxID()+1);
        System.out.println("Nhap ten");
        student.setName(sc.nextLine());
        System.out.println("Nhap gioi tinh");
        student.setSex(Boolean.parseBoolean(sc.nextLine()));
        System.out.println("Nhap sdt");
        student.setPhone(sc.nextLine());
        students.add(student);
    }
    private int getMaxID(){
        int maxID = 0;
        for(Student s: students){
            if (s.getId() > maxID){
                maxID = s.getId();
            }
        }
        return maxID;
    }

    public void editStudent(Scanner sc){
        int index = Integer.parseInt(sc.nextLine());
        students.get(index);
        students.set(index, students.get(index));
    }

}
