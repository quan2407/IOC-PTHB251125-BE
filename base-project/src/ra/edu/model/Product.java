package ra.edu.model;

import java.time.LocalDateTime;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    /*
    Menu chức năng:
    1. Hiển thị danh sách dưới dạng bảng
    2. Thêm mới
    3. Cập nhật
    4. Xóa
    5. Thống kê số lượng theo khoảng giá
    0-500k: hàng giá rẻ
    500k - 1 củ: fake, rep 1:1
    > 5 triệu: auth
    |Loại sp     | Số lượng|
    |Hàng giá rẻ| 5        |
    * */
}
