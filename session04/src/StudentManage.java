import java.util.Scanner;

public class StudentManage {
    public static void main(String[] args) {
        String[] studentName = {
                "Nguyễn Văn An",
                "Trần Thị Mai",
                "Lê Hoàng Long",
                "Phạm Minh Quân",
                "Võ Thị Ngọc Anh",
                "Đặng Quốc Bảo",
                "Bùi Thanh Tùng",
                "Ngô Thu Hà",
                "Huỳnh Đức Thịnh",
                "Phan Thị Lan"
        };
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("""
                    ---------------- MENU ----------------
                    1. Hiển thị danh sách tên sinh viên
                    2. Tìm kiếm sinh viên theo tên
                    3. Sắp xếp sinh viên theo tên (A-Z || Z-A)
                    4. Thoát
                    --------------------------------------
                    """);
            System.out.println("Nhập lựa chọn của bạn");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    printListNames(studentName, studentName.length);
                    break;
                case 2:
                    System.out.print("Nhập tên sinh viên cần tìm: ");
                    String name = sc.nextLine();
                    String[] searchNames = new String[studentName.length];
                    int n = 0;
                   for (String str : studentName) {
                       if (str.toLowerCase().contains(name.toLowerCase())) {
                           searchNames[n++] = str;
                       }
                   }
                    if (n == 0) {
                        System.out.println("Không tìm thấy");
                    } else {
                        printListNames(searchNames, n);
                    }
                    break;
                case 3:
                    System.out.println("""
                            Lựa chọn sắp xếp sinh viên theo thứ tự
                            1. A-Z
                            2. Z-A
                            """);
                    int sortChoice = Integer.parseInt(sc.nextLine());

                    for (int i = 0; i < studentName.length - 1; i++) {
                        for (int j = 0; j < studentName.length - i - 1; j++) {
                            if (sortChoice == 1) {
                                if (studentName[j].compareTo(studentName[j + 1]) > 0) {
                                    String temp = studentName[j];
                                    studentName[j] = studentName[j + 1];
                                    studentName[j + 1] = temp;
                                }
                            } else if (sortChoice == 2) {
                                if (studentName[j].compareTo(studentName[j + 1]) < 0) {
                                    String temp = studentName[j];
                                    studentName[j] = studentName[j + 1];
                                    studentName[j + 1] = temp;
                                }
                            }
                        }
                    }

                    System.out.println("Danh sách sinh viên sau khi sắp xếp:");
                    printListNames(studentName, studentName.length);
                    break;
                case 4:
                    System.out.println("Tạm biệt");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");

            }
        } while (choice != 4);
    }

    public static void printListNames(String[] names,int n) {
        System.out.printf("+%s+%s+\n", "-".repeat(5), "-".repeat(30));
        System.out.printf("| %-3s | %-28s |\n", "STT", "Họ và tên");
        for (int i = 0; i < n; i++) {

            System.out.printf("| %-3s | %-28s |\n", i + 1, names[i]);

        }
        System.out.printf("+%s+%s+\n", "-".repeat(5), "-".repeat(30));

    }
}
