import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Double> salaries = new ArrayList<>();

        double totalSalary = 0;
        double maxSalary = Double.MIN_VALUE;
        double minSalary = Double.MAX_VALUE;

        int choice;
        do {
            System.out.println("\n********* MENU QUẢN LÝ LƯƠNG *********");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng tiền thưởng");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Nhập lương nhân viên (-1 để kết thúc):");

                    totalSalary = 0;
                    maxSalary = Double.MIN_VALUE;
                    minSalary = Double.MAX_VALUE;

                    while (true) {
                        double salary = Double.parseDouble(sc.nextLine());

                        if (salary == -1) {
                            if (salaries.isEmpty()) {
                                System.out.println("Chưa có nhân viên nào.");
                            } else {
                                System.out.println("\n--- KẾT QUẢ NHẬP ---");
                                System.out.println("Tổng nhân viên: " + salaries.size());
                                System.out.println("Tổng lương: " + totalSalary);
                                System.out.println("Lương cao nhất: " + maxSalary);
                                System.out.println("Lương thấp nhất: " + minSalary);
                            }
                            break;
                        }

                        if (salary < 0 || salary > 500_000_000) {
                            System.out.println("Lương không hợp lệ (0 - 500 triệu). Nhập lại!");
                            continue;
                        }

                        // Phân loại thu nhập
                        if (salary < 5_000_000) {
                            System.out.println("Thu nhập thấp");
                        } else if (salary <= 15_000_000) {
                            System.out.println("Thu nhập trung bình");
                        } else if (salary <= 50_000_000) {
                            System.out.println("Thu nhập khá");
                        } else {
                            System.out.println("Thu nhập cao");
                        }

                        salaries.add(salary);
                        totalSalary += salary;

                        if (salary > maxSalary) maxSalary = salary;
                        if (salary < minSalary) minSalary = salary;
                    }
                    break;

                case 2:
                    if (salaries.isEmpty()) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double avgSalary = totalSalary / salaries.size();
                        System.out.println("\n--- THỐNG KÊ ---");
                        System.out.println("Số nhân viên: " + salaries.size());
                        System.out.println("Lương trung bình: " + avgSalary);
                        System.out.println("Lương cao nhất: " + maxSalary);
                        System.out.println("Lương thấp nhất: " + minSalary);
                        System.out.println("Tổng tiền lương: " + totalSalary);
                    }
                    break;

                case 3:
                    if (salaries.isEmpty()) {
                        System.out.println("Chưa có dữ liệu để tính thưởng");
                    } else {
                        double totalBonus = 0;

                        for (double salary : salaries) {
                            double bonusRate;

                            if (salary < 5_000_000) {
                                bonusRate = 0.05;
                            } else if (salary <= 15_000_000) {
                                bonusRate = 0.10;
                            } else if (salary <= 50_000_000) {
                                bonusRate = 0.15;
                            } else if (salary <= 100_000_000) {
                                bonusRate = 0.20;
                            } else {
                                bonusRate = 0.25;
                            }

                            totalBonus += salary * bonusRate;
                        }

                        System.out.println("Tổng số tiền thưởng cho nhân viên: " + totalBonus);
                    }
                    break;

                case 4:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (true);
    }
}
