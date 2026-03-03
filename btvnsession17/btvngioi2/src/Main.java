import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final OrderManager manager = new OrderManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Them SP | 2. Sua KH | 3. Tao Don | 4. Xem Don | 5. Thoat");
            System.out.print("Chon: ");
            String choice = sc.nextLine();
            try {
                switch (choice) {
                    case "1":
                        System.out.print("Ten SP: "); String pName = sc.nextLine();
                        System.out.print("Gia: "); double price = Double.parseDouble(sc.nextLine());
                        manager.addProduct(new Product(pName, price));
                        break;
                    case "2":
                        System.out.print("ID KH can sua: "); int cId = Integer.parseInt(sc.nextLine());
                        System.out.print("Ten moi: "); String cName = sc.nextLine();
                        System.out.print("Email moi: "); String cEmail = sc.nextLine();
                        manager.updateCustomer(cId, new Customer(cName, cEmail));
                        break;
                    case "3":
                        System.out.print("ID Khach: "); int custId = Integer.parseInt(sc.nextLine());
                        System.out.print("ID San pham: "); int prodId = Integer.parseInt(sc.nextLine());
                        System.out.print("So luong: "); int qty = Integer.parseInt(sc.nextLine());
                        manager.createOrder(custId, prodId, qty);
                        break;
                    case "4":
                        manager.listAllOrders();
                        break;
                    case "5": return;
                    default: System.out.println("Lua chon sai.");
                }
            } catch (Exception e) {
                System.err.println("Loi nhap lieu: " + e.getMessage());
            }
        }
    }
}