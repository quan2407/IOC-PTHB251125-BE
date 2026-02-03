import ra.business.AppointmentBusiness;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentBusiness business = new AppointmentBusiness();

        while (true) {
            System.out.println("\n===== QUẢN LÝ LỊCH HẸN KHÁM BỆNH =====");
            System.out.println("1. Thêm lịch hẹn mới");
            System.out.println("2. Hiển thị danh sách (Ngày tăng dần)");
            System.out.println("3. Tìm kiếm theo tên bệnh nhân");
            System.out.println("4. Cập nhật lịch hẹn");
            System.out.println("5. Xóa lịch hẹn");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: business.addAppointment(scanner); break;
                    case 2: business.displayAppointments(); break;
                    case 3: business.searchByPatientName(scanner); break;
                    case 4: business.updateAppointment(scanner); break;
                    case 5: business.deleteAppointment(scanner); break;
                    case 6: business.showStatistics(); break;
                    case 7: System.exit(0);
                    default: System.err.println("Sai lựa chọn!");
                }
            } catch (Exception e) {
                System.err.println("Lỗi nhập liệu!");
            }
        }
    }
}