import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ProductManager pm = new ProductManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n********************PRODUCT MANAGEMENT****************");
            System.out.println("1. Danh sach san pham");
            System.out.println("2. Them moi san pham");
            System.out.println("3. Cap nhat san pham");
            System.out.println("4. Xoa san pham");
            System.out.println("5. Tim kiem san pham theo ten");
            System.out.println("6. Sap xep san pham theo gia tang dan");
            System.out.println("7. Thong ke theo danh muc");
            System.out.println("8. Thoat");
            System.out.print("Lua chon: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: pm.listAllProducts(); break;
                    case 2: handleAdd(); break;
                    case 3: handleUpdate(); break;
                    case 4: handleDelete(); break;
                    case 5:
                        System.out.print("Nhap ten can tim: ");
                        pm.searchByName(sc.nextLine());
                        break;
                    case 6: pm.sortByPrice(); break;
                    case 7: pm.statistics(); break;
                    case 8: return;
                    default: System.out.println("Chon tu 1-8.");
                }
            } catch (Exception e) {
                System.err.println("Loi: " + e.getMessage());
            }
        }
    }

    private static void handleAdd() {
        System.out.print("Ten SP: "); String name = validate(sc.nextLine());
        System.out.print("Gia (>0): "); float price = Float.parseFloat(sc.nextLine());
        if(price <= 0) throw new IllegalArgumentException("Gia phai lon hon 0");
        System.out.print("Tieu de: "); String title = validate(sc.nextLine());
        System.out.print("Ngay tao (yyyy-mm-dd): "); String date = validate(sc.nextLine());
        System.out.print("Danh muc: "); String catalog = validate(sc.nextLine());
        System.out.print("Trang thai (true/false): "); boolean status = Boolean.parseBoolean(sc.nextLine());
        pm.addProduct(name, price, title, date, catalog, status);
    }

    private static void handleUpdate() {
        System.out.print("ID SP can sua: "); int id = Integer.parseInt(sc.nextLine());
        System.out.print("Ten moi: "); String name = validate(sc.nextLine());
        System.out.print("Gia moi: "); float price = Float.parseFloat(sc.nextLine());
        System.out.print("Tieu de moi: "); String title = validate(sc.nextLine());
        System.out.print("Danh muc moi: "); String catalog = validate(sc.nextLine());
        System.out.print("Trang thai moi (true/false): "); boolean status = Boolean.parseBoolean(sc.nextLine());
        pm.updateProduct(id, name, price, title, catalog, status);
    }

    private static void handleDelete() {
        System.out.print("ID SP can xoa: ");
        pm.deleteProduct(Integer.parseInt(sc.nextLine()));
    }

    private static String validate(String s) {
        if (s == null || s.trim().isEmpty()) throw new IllegalArgumentException("Khong duoc de trong.");
        return s.trim();
    }
}