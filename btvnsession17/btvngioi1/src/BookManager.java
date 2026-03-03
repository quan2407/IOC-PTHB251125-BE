import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {

    // 1. Them sach (Kiem tra trung ten + tac gia)
    public void addBook(Book book) {
        if (isBookExists(book.getTitle(), book.getAuthor())) {
            System.err.println("Loi: Sach nay da ton tai trong thu vien.");
            return;
        }

        String sql = "INSERT INTO books (title, author, published_year, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getPublishedYear());
            pstmt.setDouble(4, book.getPrice());
            pstmt.executeUpdate();
            System.out.println("Them sach thanh cong.");
        } catch (SQLException e) {
            System.err.println("Loi khi them sach: " + e.getMessage());
        }
    }

    // 2. Cap nhat sach
    public void updateBook(int id, Book book) {
        String sql = "UPDATE books SET title = ?, author = ?, published_year = ?, price = ? WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getPublishedYear());
            pstmt.setDouble(4, book.getPrice());
            pstmt.setInt(5, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cap nhat sach thanh cong.");
            } else {
                System.err.println("Khong tim thay sach voi ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Loi cap nhat: " + e.getMessage());
        }
    }

    // 3. Xoa sach
    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Xoa sach thanh cong.");
            } else {
                System.err.println("Khong tim thay ID de xoa.");
            }
        } catch (SQLException e) {
            System.err.println("Loi khi xoa: " + e.getMessage());
        }
    }

    // 4. Tim kiem theo tac gia
    public void findBooksByAuthor(String author) {
        String sql = "SELECT * FROM books WHERE author ILIKE ?";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + author + "%");
            ResultSet rs = pstmt.executeQuery();
            displayResultSet(rs);
        } catch (SQLException e) {
            System.err.println("Loi tim kiem: " + e.getMessage());
        }
    }

    // 5. Liet ke tat ca
    public void listAllBooks() {
        String sql = "SELECT * FROM books";
        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            displayResultSet(rs);
        } catch (SQLException e) {
            System.err.println("Loi liet ke: " + e.getMessage());
        }
    }

    private boolean isBookExists(String title, String author) {
        String sql = "SELECT COUNT(*) FROM books WHERE title = ? AND author = ?";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void displayResultSet(ResultSet rs) throws SQLException {
        boolean hasData = false;
        while (rs.next()) {
            hasData = true;
            System.out.printf("ID: %d | Ten: %s | Tac gia: %s | Nam: %d | Gia: %.2f\n",
                    rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                    rs.getInt("published_year"), rs.getDouble("price"));
        }
        if (!hasData) System.out.println("Khong co du lieu.");
    }
}