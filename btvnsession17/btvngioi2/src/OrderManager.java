import java.sql.*;

public class OrderManager {

    public void addProduct(Product p) {
        String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.name);
            pstmt.setDouble(2, p.price);
            pstmt.executeUpdate();
            System.out.println("Them san pham thanh cong.");
        } catch (SQLException e) {
            System.err.println("Loi: Ten san pham co the da ton tai.");
        }
    }

    public void updateCustomer(int id, Customer c) {
        String sql = "UPDATE customers SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, c.name);
            pstmt.setString(2, c.email);
            pstmt.setInt(3, id);
            if (pstmt.executeUpdate() > 0) System.out.println("Cap nhat khach hang thanh cong.");
            else System.err.println("Khong tim thay ID khach hang.");
        } catch (SQLException e) {
            System.err.println("Loi: Email co the bi trung.");
        }
    }

    public void createOrder(int customerId, int productId, int quantity) {
        String getPriceSql = "SELECT price FROM products WHERE id = ?";
        String insertOrderSql = "INSERT INTO orders (customer_id, total_amount) VALUES (?, ?)";

        try (Connection conn = ConnectionDB.getConnection()) {
            // Lay gia san pham
            double price = 0;
            try (PreparedStatement p1 = conn.prepareStatement(getPriceSql)) {
                p1.setInt(1, productId);
                ResultSet rs = p1.executeQuery();
                if (rs.next()) price = rs.getDouble("price");
                else { System.err.println("San pham khong ton tai."); return; }
            }

            // Tao don hang
            try (PreparedStatement p2 = conn.prepareStatement(insertOrderSql)) {
                p2.setInt(1, customerId);
                p2.setDouble(2, price * quantity);
                p2.executeUpdate();
                System.out.println("Tao don hang thanh cong. Tong tien: " + (price * quantity));
            }
        } catch (SQLException e) {
            System.err.println("Loi khi tao don hang: " + e.getMessage());
        }
    }

    public void listAllOrders() {
        String sql = "SELECT o.id, c.name, o.order_date, o.total_amount " +
                "FROM orders o JOIN customers c ON o.customer_id = c.id";
        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("Don hang: %d | KH: %s | Ngay: %s | Tong: %.2f\n",
                        rs.getInt("id"), rs.getString("name"),
                        rs.getDate("order_date"), rs.getDouble("total_amount"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
}