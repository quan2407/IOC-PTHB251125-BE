public class Main {
    public static void main(String[] args) {
        // String là 1 Class java
        String name = "Nguyen Van A";
        // String trong Java vừa nguyên thủy vừa có tính tham chiếu
        // Cách 1 khởi tạo trực tiếp
        String str = "Hello World"; // khởi tạo theo hướng nguyên thủy (String pool)
        // nếu có biến thứ 2 khởi tạo trùng với giá trị cũ thì nó không tạo cái mới mà chiếu trùng
        // với cái cũ
        String str2 = "Hello World";
        System.out.println("Địa chỉ str1: " + System.identityHashCode(str));
        System.out.println("Địa ch str2: " + System.identityHashCode(str2));

        // Cách 2 : Khởi tạo thông qua từ khóa new (Cấp phát động)
        String str3 = new String("Hello World");
        String str4 = new String("Hello World");
        System.out.println("Địa chỉ str3: " + System.identityHashCode(str3));
        System.out.println("Địa chỉ str4: " + System.identityHashCode(str4));

    }
}
