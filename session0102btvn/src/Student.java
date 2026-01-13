import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> studentMarks = new ArrayList<>();

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int choice;
        do {
            System.out.println("\n********* MENU NHẬP ĐIỂM *********");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Nhập điểm học viên (-1 để kết thúc):");
                    sum = 0;
                    max = Integer.MIN_VALUE;
                    min = Integer.MAX_VALUE;

                    while (true) {
                        int mark = Integer.parseInt(sc.nextLine());

                        if (mark == -1) {
                            if (studentMarks.isEmpty()) {
                                System.out.println("Chưa có học viên nào được nhập.");
                            } else {
                                System.out.println("\n--- KẾT QUẢ NHẬP ---");
                                System.out.println("Tổng số học viên: " + studentMarks.size());
                                System.out.println("Tổng điểm: " + sum);
                                System.out.println("Điểm cao nhất: " + max);
                                System.out.println("Điểm thấp nhất: " + min);
                            }
                            break;
                        }

                        if (mark < 0 || mark > 10) {
                            System.out.println("Điểm không hợp lệ, vui lòng nhập lại!");
                            continue;
                        }

                        if (mark <= 5) {
                            System.out.println("Yếu");
                        } else if (mark <= 7) {
                            System.out.println("Trung Bình");
                        } else if (mark <= 8) {
                            System.out.println("Khá");
                        } else if (mark <= 9) {
                            System.out.println("Giỏi");
                        } else {
                            System.out.println("Xuất sắc");
                        }

                        studentMarks.add(mark);
                        sum += mark;
                        if (mark > max) max = mark;
                        if (mark < min) min = mark;
                    }
                    break;

                case 2:
                    if (studentMarks.isEmpty()) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double avg = (double) sum / studentMarks.size();
                        System.out.println("\n--- THỐNG KÊ ---");
                        System.out.println("Số học viên: " + studentMarks.size());
                        System.out.println("Điểm trung bình: " + avg);
                        System.out.println("Điểm cao nhất: " + max);
                        System.out.println("Điểm thấp nhất: " + min);
                    }
                    break;

                case 3:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }
}
