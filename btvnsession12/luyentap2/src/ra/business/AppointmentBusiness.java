package ra.business;

import ra.entity.Appointment;
import java.util.*;
import java.util.stream.Collectors;

public class AppointmentBusiness {
    private List<Appointment> listAppointments = new ArrayList<>();

    public void addAppointment(Scanner scanner) {
        Appointment app = new Appointment();
        while (true) {
            app.inputData(scanner);
            boolean isExist = listAppointments.stream()
                    .anyMatch(a -> a.getAppointmentId().equals(app.getAppointmentId()));
            if (isExist) {
                System.err.println("Mã lịch hẹn đã tồn tại! Vui lòng nhập lại.");
            } else {
                break;
            }
        }
        listAppointments.add(app);
        System.out.println("Thêm lịch hẹn thành công!");
    }

    public void displayAppointments() {
        if (listAppointments.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        listAppointments.sort(Comparator.comparing(Appointment::getAppointmentDate));
        System.out.println("--- DANH SÁCH LỊCH HẸN (SẮP XẾP THEO NGÀY) ---");
        listAppointments.forEach(System.out::println);
    }

    public void searchByPatientName(Scanner scanner) {
        System.out.print("Nhập tên bệnh nhân cần tìm: ");
        String name = scanner.nextLine().toLowerCase();
        List<Appointment> results = listAppointments.stream()
                .filter(a -> a.getPatientName().toLowerCase().contains(name))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            System.out.println("Không tìm thấy kết quả nào.");
        } else {
            results.forEach(System.out::println);
        }
    }

    public void updateAppointment(Scanner scanner) {
        System.out.print("Nhập mã lịch hẹn cần cập nhật: ");
        String id = scanner.nextLine();

        Optional<Appointment> appointmentOpt = listAppointments.stream()
                .filter(a -> a.getAppointmentId().equals(id))
                .findFirst();

        appointmentOpt.ifPresentOrElse(
                app -> {
                    System.out.println("Đã tìm thấy! Nhập thông tin mới:");
                    app.inputData(scanner);
                    System.out.println("Cập nhật thành công!");
                },
                () -> System.err.println("Không tìm thấy mã lịch hẹn: " + id)
        );
    }

    public void deleteAppointment(Scanner scanner) {
        System.out.print("Nhập mã cần xóa: ");
        String id = scanner.nextLine();

        listAppointments.stream()
                .filter(a -> a.getAppointmentId().equals(id))
                .findFirst()
                .ifPresentOrElse(app -> {
                    System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
                    if (scanner.nextLine().equalsIgnoreCase("Y")) {
                        listAppointments.remove(app);
                        System.out.println("Đã xóa thành công.");
                    }
                }, () -> System.err.println("Không tìm thấy mã!"));
    }

    public void showStatistics() {
        System.out.println("Tổng số lịch hẹn: " + listAppointments.size());

        Map<String, Long> statsByDoctor = listAppointments.stream()
                .collect(Collectors.groupingBy(Appointment::getDoctor, Collectors.counting()));

        System.out.println("Số lịch hẹn theo từng bác sĩ:");
        statsByDoctor.forEach((doctor, count) ->
                System.out.println("- Bác sĩ " + doctor + ": " + count + " lịch hẹn"));
    }
}