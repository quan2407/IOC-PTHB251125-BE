import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookManager manager = new BookManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU QUAN LY THU VIEN ---");
            System.out.println("1. Them sach");
            System.out.println("2. Cap nhat sach");
            System.out.println("3. Xoa sach");
            System.out.println("4. Tim kiem theo tac gia");
            System.out.println("5. Hien thi tat ca sach");
            System.out.println("6. Thoat");
            System.out.print("Lua chon: ");

            String choice = scanner.nextLine();
            try {
                switch (choice) {
                    case "1":
                        manager.addBook(inputBookInfo());
                        break;
                    case "2":
                        System.out.print("Nhap ID sach can sua: ");
                        int updateId = Integer.parseInt(scanner.nextLine());
                        manager.updateBook(updateId, inputBookInfo());
                        break;
                    case "3":
                        System.out.print("Nhap ID sach can xoa: ");
                        int delId = Integer.parseInt(scanner.nextLine());
                        manager.deleteBook(delId);
                        break;
                    case "4":
                        System.out.print("Nhap ten tac gia: ");
                        manager.findBooksByAuthor(validateNotEmpty(scanner.nextLine()));
                        break;
                    case "5":
                        manager.listAllBooks();
                        break;
                    case "6":
                        return;
                    default:
                        System.out.println("Lua chon sai.");
                }
            } catch (Exception e) {
                System.err.println("Loi nhap lieu: " + e.getMessage());
            }
        }
    }

    private static Book inputBookInfo() {
        System.out.print("Tieu de: ");
        String title = validateNotEmpty(scanner.nextLine());
        System.out.print("Tac gia: ");
        String author = validateNotEmpty(scanner.nextLine());
        System.out.print("Nam xuat ban: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Gia: ");
        double price = Double.parseDouble(scanner.nextLine());
        return new Book(title, author, year, price);
    }

    private static String validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Khong duoc de trong.");
        }
        return input.trim();
    }
}