import java.sql.*;

public class MovieManagement {

    // 1. Thêm phim mới (Sử dụng Procedure add_movie)
    public void addMovie(String title, String director, int year) {
        String sql = "{call add_movie(?, ?, ?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setString(1, title);
            cstmt.setString(2, director);
            cstmt.setInt(3, year);
            cstmt.execute();
            System.out.println("Thêm phim thành công!");

        } catch (SQLException e) {
            System.err.println("Lỗi CSDL khi thêm: " + e.getMessage());
        }
    }

    // 2. Liệt kê phim (Sử dụng Function list_movies())
    public void listMovies() {
        String sql = "SELECT * FROM list_movies()";
        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- DANH SÁCH PHIM ---");
            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                System.out.printf("ID: %-3d | Tiêu đề: %-20s | Đạo diễn: %-15s | Năm: %d\n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getInt("release_year"));
            }
            if (!hasData) System.out.println("Danh sách trống.");
            System.out.println("-------------------------");

        } catch (SQLException e) {
            System.err.println("Lỗi hiển thị danh sách: " + e.getMessage());
        }
    }

    // 3. Cập nhật phim (Sử dụng Procedure update_movie)
    public void updateMovie(int id, String title, String director, int year) {
        String sql = "{call update_movie(?, ?, ?, ?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, id);
            cstmt.setString(2, title);
            cstmt.setString(3, director);
            cstmt.setInt(4, year);
            cstmt.execute();
            System.out.println("Cập nhật thành công phim ID: " + id);

        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật: " + e.getMessage());
        }
    }

    // 4. Xóa phim (Sử dụng Procedure delete_movie)
    public void deleteMovie(int id) {
        String sql = "{call delete_movie(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, id);
            cstmt.execute();
            System.out.println("Đã xóa phim ID: " + id);

        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa: " + e.getMessage());
        }
    }
}