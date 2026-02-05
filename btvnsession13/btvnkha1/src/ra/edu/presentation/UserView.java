package ra.edu.presentation;

import ra.edu.business.IUserService;
import ra.edu.business.ra.business.impl.UserServiceImpl;
import ra.edu.model.User;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private static final IUserService userService = new UserServiceImpl();

    public static void showMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n**************** MENU QUẢN LÝ NGƯỜI DÙNG ****************");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số từ 1 đến 4!");
                choice = 0;
            }

            switch (choice) {
                case 1:
                   addUser(scanner);
                    break;
                case 2:
                   deleteUser(scanner);
                    break;
                case 3:
                    showAllUsers();
                    break;
                case 4:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (choice != 4);
    }
    private static void addUser(Scanner scanner) {
        List<User> users = userService.findAll();
        int maxId = userService.getMaxId();
        User user = new User();
        user.setId(maxId);
        user.inputData(scanner);
        userService.add(user);
    }
    private static void deleteUser(Scanner scanner) {
        List<User> users = userService.findAll();
        System.out.println("Nhập email cần xóa");
        String email = scanner.nextLine();
        userService.deleteByEmail(email);
    }
    private static void showAllUsers() {
        List<User> users = userService.findAll();
        for (User user : users) {
            user.displayData();
        }
    }
}