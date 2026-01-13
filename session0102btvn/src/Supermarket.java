import java.util.Scanner;

public class Supermarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên khách hàng: ");
        String cusName = sc.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String productName = sc.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập số lượng mua: ");
        int quantity = Integer.parseInt(sc.nextLine());

        System.out.print("Có thẻ thành viên hay không (true/false): ");
        boolean isMember = Boolean.parseBoolean(sc.nextLine());

        double thanhTien = price * quantity;
        double giamGia = isMember ? thanhTien * 0.1 : 0;
        double VAT = (thanhTien - giamGia) * 0.08;
        double tongTienThanhToan = thanhTien - giamGia + VAT;

        System.out.println("\n------ KẾT QUẢ ------");
        System.out.println("Khách hàng: " + cusName);
        System.out.println("Sản phẩm: " + productName);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Đơn giá: " + price);
        System.out.println("Thành tiền: " + thanhTien);
        System.out.println("Giảm giá: " + giamGia);
        System.out.println("VAT (8%): " + VAT);
        System.out.println("Tổng thanh toán: " + tongTienThanhToan);
    }
}
