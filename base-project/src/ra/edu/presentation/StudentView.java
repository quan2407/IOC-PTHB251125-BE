package ra.edu.presentation;

import ra.edu.business.IStudentService;
import ra.edu.business.impl.StudentServiceImpl;
import ra.edu.model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    private static final IStudentService studentService = new StudentServiceImpl();
    public static void showMenu(Scanner scanner) {
        while(true){
            System.out.println("--------------MENU------------");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật thông tin sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Tìm sinh viên theo tên");
            System.out.println("6. Sắp xếp sinh viên theo a-z tên");
            System.out.println("7. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    showListStudent();
                    break;
            }
        }
    }
    private static void showListStudent(){
        List<Student> list = studentService.findAll();
        if(list.isEmpty()){
            System.out.println("Danh sách trống");
        } else {
            for(Student student : list){
                student.displayData();
            }
        }
    }
    public static void sortListStudent(){
        studentService.sort();
        System.out.println("Danh sách sinh viên sau khi sắp xếp");
        showListStudent();

    }
}
