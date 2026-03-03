import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskManagement management = new TaskManagement();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU TO-DO LIST ---");
            System.out.println("1. Them cong viec");
            System.out.println("2. Liet ke cong viec");
            System.out.println("3. Cap nhat trang thai");
            System.out.println("4. Xoa cong viec");
            System.out.println("5. Tim kiem cong viec");
            System.out.println("6. Thong ke");
            System.out.println("7. Thoat");
            System.out.print("Nhap lua chon: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Nhap ten cong viec: ");
                        String name = validateInput(scanner.nextLine());
                        System.out.print("Trang thai (1: chua hoan thanh, 2: da hoan thanh): ");
                        String statusInput = scanner.nextLine();
                        String status = statusInput.equals("2") ? "đã hoàn thành" : "chưa hoàn thành";
                        management.addTask(name, status);
                        break;
                    case "2":
                        management.listTasks();
                        break;
                    case "3":
                        System.out.print("Nhap ID cong viec: ");
                        int updateId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Trang thai moi (1: chua hoan thanh, 2: da hoan thanh): ");
                        String newStatus = scanner.nextLine().equals("2") ? "đã hoàn thành" : "chưa hoàn thành";
                        management.updateTaskStatus(updateId, newStatus);
                        break;
                    case "4":
                        System.out.print("Nhap ID muon xoa: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        management.deleteTask(deleteId);
                        break;
                    case "5":
                        System.out.print("Nhap ten can tim: ");
                        String searchName = validateInput(scanner.nextLine());
                        management.searchTaskByName(searchName);
                        break;
                    case "6":
                        management.taskStatistics();
                        break;
                    case "7":
                        System.out.println("Ket thuc chuong trinh.");
                        return;
                    default:
                        System.out.println("Lua chon khong hop le.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Loi: ID phai la mot so.");
            } catch (IllegalArgumentException e) {
                System.err.println("Loi: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Co loi xay ra: " + e.getMessage());
            }
        }
    }

    private static String validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Du lieu khong duoc de trong.");
        }
        return input.trim();
    }
}