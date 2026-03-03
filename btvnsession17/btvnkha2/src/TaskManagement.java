import java.sql.*;

public class TaskManagement {

    public void addTask(String taskName, String status) {
        String sql = "{call add_task(?, ?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, taskName);
            cstmt.setString(2, status);
            cstmt.execute();
            System.out.println("Them cong viec thanh cong.");
        } catch (SQLException e) {
            System.err.println("Loi DB: " + e.getMessage());
        }
    }

    public void listTasks() {
        String sql = "SELECT * FROM list_tasks()";
        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- DANH SACH CONG VIEC ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Ten: %s | Trang thai: %s\n",
                        rs.getInt("id"), rs.getString("task_name"), rs.getString("status"));
            }
        } catch (SQLException e) {
            System.err.println("Loi: " + e.getMessage());
        }
    }

    public void updateTaskStatus(int taskId, String status) {
        String sql = "{call update_task_status(?, ?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, taskId);
            cstmt.setString(2, status);
            cstmt.execute();
            System.out.println("Cap nhat trang thai thanh cong.");
        } catch (SQLException e) {
            System.err.println("Loi: " + e.getMessage());
        }
    }

    public void deleteTask(int taskId) {
        String sql = "{call delete_task(?)}";
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, taskId);
            cstmt.execute();
            System.out.println("Da xoa cong viec.");
        } catch (SQLException e) {
            System.err.println("Loi: " + e.getMessage());
        }
    }

    public void searchTaskByName(String taskName) {
        String sql = "SELECT * FROM search_task_by_name(?)";
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, taskName);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("\n--- KET QUA TIM KIEM ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Ten: %s | Trang thai: %s\n",
                        rs.getInt("id"), rs.getString("task_name"), rs.getString("status"));
            }
        } catch (SQLException e) {
            System.err.println("Loi tim kiem: " + e.getMessage());
        }
    }

    public void taskStatistics() {
        String sql = "SELECT * FROM task_statistics()";
        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                System.out.println("\n--- THONG KE ---");
                System.out.println("Da hoan thanh: " + rs.getLong("completed_count"));
                System.out.println("Chua hoan thanh: " + rs.getLong("pending_count"));
            }
        } catch (SQLException e) {
            System.err.println("Loi thong ke: " + e.getMessage());
        }
    }
}