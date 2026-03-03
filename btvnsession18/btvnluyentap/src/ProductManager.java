import java.sql.*;
import java.util.Scanner;

public class ProductManager {

    public void listAllProducts() {
        String sql = "SELECT * FROM get_all_products()";
        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            printHeader();
            while (rs.next()) {
                printProduct(rs);
            }
        } catch (SQLException e) {
            System.err.println("Loi: " + e.getMessage());
        }
    }

    public void addProduct(String name, float price, String title, String date, String catalog, boolean status) {
        String sql = "{call add_product(?, ?, ?, ?, ?, ?)}";
        try (Connection conn = ConnectionDB.getConnection()) {
            conn.setAutoCommit(false); // Bat dau Transaction
            try (CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.setString(1, name);
                cstmt.setFloat(2, price);
                cstmt.setString(3, title);
                cstmt.setDate(4, Date.valueOf(date)); // Định dạng yyyy-mm-dd
                cstmt.setString(5, catalog);
                cstmt.setBoolean(6, status);
                cstmt.execute();
                conn.commit(); // Hoàn tất Transaction
                System.out.println("Them san pham thanh cong.");
            } catch (SQLException e) {
                conn.rollback(); // Huy neu loi
                System.err.println("Loi (Rollback): " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(int id, String name, float price, String title, String catalog, boolean status) {
        String sql = "{call update_product(?, ?, ?, ?, ?, ?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, id);
            cstmt.setString(2, name);
            cstmt.setFloat(3, price);
            cstmt.setString(4, title);
            cstmt.setString(5, catalog);
            cstmt.setBoolean(6, status);
            int rows = cstmt.executeUpdate();
            System.out.println("Cap nhat thanh cong.");
        } catch (SQLException e) {
            System.err.println("Loi: " + e.getMessage());
        }
    }

    public void deleteProduct(int id) {
        String sql = "{call delete_product(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, id);
            cstmt.execute();
            System.out.println("Da xoa san pham.");
        } catch (SQLException e) {
            System.err.println("Loi: " + e.getMessage());
        }
    }

    public void searchByName(String name) {
        String sql = "SELECT * FROM search_product_by_name(?)";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            printHeader();
            while (rs.next()) printProduct(rs);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void sortByPrice() {
        String sql = "SELECT * FROM Product ORDER BY Product_Price ASC";
        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            printHeader();
            while (rs.next()) printProduct(rs);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void statistics() {
        String sql = "SELECT * FROM statistics_by_catalog()";
        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- THONG KE ---");
            while (rs.next()) {
                System.out.printf("DanhMuc: %-15s | SoLuong: %d\n",
                        rs.getString("catalog_name"), rs.getLong("total_count"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private void printHeader() {
        System.out.printf("%-5s | %-20s | %-10s | %-15s | %-10s\n", "ID", "Ten", "Gia", "DanhMuc", "TrangThai");
    }

    private void printProduct(ResultSet rs) throws SQLException {
        System.out.printf("%-5d | %-20s | %-10.2f | %-15s | %-10s\n",
                rs.getInt("Product_Id"), rs.getString("Product_Name"),
                rs.getFloat("Product_Price"), rs.getString("Product_catalog"),
                rs.getBoolean("Product_Status") ? "Con hang" : "Het hang");
    }
}