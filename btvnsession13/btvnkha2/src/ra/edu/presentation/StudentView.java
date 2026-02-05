package ra.edu.presentation;
import ra.edu.bussiness.IStudentService;
import ra.edu.bussiness.impl.StudentServiceImpl;
import ra.edu.model.Student;


import java.util.List;
import java.util.Scanner;

public class StudentView {
    private static final IStudentService studentService = new StudentServiceImpl();

    public static void showMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n**************** MENU QUẢN LÝ ĐIỂM DANH ****************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Vui lòng nhập số từ 1 đến 5!");
                choice = 0;
            }

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    editStudent(scanner);
                    break;
                case 3:
                    deleteStudent(scanner);
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Đang thoát chương trình quản lý điểm danh...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Thử lại nhé!");
            }
        } while (choice != 5);
    }

    // Các phương thức hỗ trợ để code trong switch-case nhìn sạch hơn
    private static void addStudent(Scanner scanner) {
        Student s = new Student();
        int maxId = studentService.getMaxId();
        s.setId(maxId+1);
        s.inputData(scanner);
        studentService.add(s);
        // Triển khai logic thêm sinh viên ở đây
    }

    private static void editStudent(Scanner scanner) {
        System.out.println("Nhập ID sinh viên cần sửa: ");
        int idEdit = Integer.parseInt(scanner.nextLine());

        Student studentEdit = studentService.findById(idEdit);

        if (studentEdit != null) {
            System.out.println("Thông tin hiện tại của sinh viên:");
            studentEdit.displayData();


            System.out.println("--- Nhập thông tin cập nhật ---");
            studentEdit.inputData(scanner);

            studentService.update(studentEdit, idEdit);
            System.out.println("Cập nhật thành công!");
        } else {
            System.err.println("Không tìm thấy sinh viên có ID: " + idEdit);
        }
    }

    private static void deleteStudent(Scanner scanner) {
        // Triển khai logic xóa sinh viên ở đây
        System.out.println("Nhập ID sinh viên cần xóa: ");
        int idDelete = Integer.parseInt(scanner.nextLine());

        Student studentDelete = studentService.findById(idDelete);

        if (studentDelete != null) {
            studentService.delete(idDelete);
        } else {
            System.err.println("Không tìm thấy sinh viên có ID: " + idDelete);
        }
    }

    private static void displayAllStudents() {
        List<Student> list = studentService.findAll();
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
        } else {
            for (Student s : list) {
                s.displayData();
            }
        }
    }
}