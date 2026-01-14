import java.util.Arrays;

public class DynamicArray {
    static final int MAX = 1000;

    public static void main(String[] args) {
        // Quản lý mảng: thêm sửa xóa tìm kiếm phần tử trong 1 mảng
        int[] array = new int[MAX];
        for (int i = 1; i < 7; i++) {
            array[i] = i;
        }
        int n = 6;

        // chèn
        add(array,n,100,2);
        System.out.println(Arrays.toString(array));
        // xóa thì dịch phần tử bên pahỉ vị trí(ngược lại với chèn là được)
    }

    public static void add(int[] arr,int n, int value,int idx){
        // 1,2,3,4,5 -> chèn 100 tại idx =2
        // => 1,2,100,3,4,5
        if (n >= MAX){
            System.err.println("Mang da day");
        } else {
            // dich cac phan tu ben phai
            for (int i = n; i > idx; i--) {
                arr[i] = arr[i - 1];
            }
            // gan vao vi tri chen
            arr[idx] = value;
        }
    }
}
