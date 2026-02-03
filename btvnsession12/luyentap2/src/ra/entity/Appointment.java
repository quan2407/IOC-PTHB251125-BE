package ra.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String phoneNumber;
    private LocalDate appointmentDate;
    private String doctor;

    public Appointment() {}

    public Appointment(String appointmentId, String patientName, String phoneNumber, LocalDate appointmentDate, String doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    // Getter và Setter
    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
    public String getDoctor() { return doctor; }
    public void setDoctor(String doctor) { this.doctor = doctor; }

    public void inputData(Scanner scanner) {
        while (true) {
            System.out.print("Nhập mã lịch hẹn (6 ký tự): ");
            this.appointmentId = scanner.nextLine();
            if (this.appointmentId.length() == 6) break;
            System.err.println("Mã lịch hẹn phải đúng 6 ký tự!");
        }

        while (true) {
            System.out.print("Nhập tên bệnh nhân (10-50 ký tự): ");
            this.patientName = scanner.nextLine();
            if (this.patientName.length() >= 10 && this.patientName.length() <= 50) break;
            System.err.println("Tên bệnh nhân không hợp lệ!");
        }

        while (true) {
            System.out.print("Nhập số điện thoại: ");
            this.phoneNumber = scanner.nextLine();
            if (this.phoneNumber.matches("^(0|\\+84)(\\d{9})$")) break;
            System.err.println("Số điện thoại không đúng định dạng VN!");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print("Nhập ngày hẹn (dd/MM/yyyy): ");
            String dateStr = scanner.nextLine();
            try {
                this.appointmentDate = LocalDate.parse(dateStr, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Ngày hẹn không đúng định dạng dd/MM/yyyy!");
            }
        }

        while (true) {
            System.out.print("Nhập bác sĩ phụ trách: ");
            this.doctor = scanner.nextLine();
            if (this.doctor.length() <= 200 && !this.doctor.isEmpty()) break;
            System.err.println("Tên bác sĩ không hợp lệ!");
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %s | BN: %-15s | SĐT: %s | Ngày: %s | BS: %s",
                appointmentId, patientName, phoneNumber,
                appointmentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), doctor);
    }
}