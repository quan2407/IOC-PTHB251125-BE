import java.util.Scanner;

public class NumberMenu {
    public static void main(String[] args) {
        int choice = 0;
        int[] array = null;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-----------MENU----------");
            System.out.println("1. Nhập số lượng phần tử cần khởi tạo");
            System.out.println("2. Tìm và in ra giá trị lớn nhất, nhỏ nhất");
            System.out.println("3. Tìm giá trị lớn thứ 2");
            System.out.println("4. Tìm ra các số chính phương trong mảng");
            System.out.println("5. Tính tổng lũy thừa bậc 3 của các số trong mảng");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng phần tử: ");
                    int n = Integer.parseInt(sc.nextLine());
                    array = new int[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập phần tử thứ " + i);
                        array[i] = Integer.parseInt(sc.nextLine());
                    }
                    break;
                case 2:
                    if (array == null || array.length == 0) {
                        System.out.println("Bạn cần thực hiện mục 1 (Nhập mảng) trước!");
                    } else {
                        int max = array[0];
                        int min = array[0];
                        for (int i = 1; i < array.length; i++) {
                            if (array[i] > max) max = array[i];
                            if (array[i] < min) min = array[i];
                        }
                        System.out.println("Giá trị lớn nhất: " + max);
                        System.out.println("Giá trị nhỏ nhất: " + min);
                    }
                    break;
                case 3:
                    if (array == null || array.length == 0) {
                        System.out.println("Bạn cần thực hiện mục 1 (Nhập mảng) trước!");
                    } else {
                        int max = array[0];
                        int secondMax = array[0];
                        for (int i = 1; i < array.length; i++) {
                            if (array[i] > max) {
                                secondMax = max;
                                max = array[i];
                            } else if (array[i] > secondMax && array[i] < max) {
                                secondMax = array[i];
                            }
                        }
                        System.out.println("Gía trị lớn nhất: " + max);
                        System.out.println("Gía trị nhỏ nhất: " + secondMax);
                    }
                    break;
                case 4:
                    if (array == null || array.length == 0) {
                        System.out.println("Bạn cần thực hiện mục 1 (Nhập mảng) trước!");
                    } else {
                        int[] mangSoChinhPhuong = new int[array.length];
                        int count = 0;
                        for (int i = 0; i < array.length; i++) {
                            int sqrt = (int) Math.sqrt(array[i]);
                            if (array[i] == sqrt * sqrt) {
                                mangSoChinhPhuong[count++] = array[i];
                            }
                        }
                        if (count == 0) {
                            System.out.println("Không có số chính phương trong mảng");
                        } else {
                            System.out.print("Các số chính phương: ");
                            for (int i = 0; i < count; i++) {
                                System.out.print(mangSoChinhPhuong[i] + " ");
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 5:
                    if (array == null || array.length == 0) {
                        System.out.println("Bạn cần thực hiện mục 1 (Nhập mảng) trước!");
                    } else {
                        int sum = 0;
                        for (int i = 0; i < array.length; i++) {
                            sum += array[i] * array[i] * array[i];
                        }
                        System.out.println("Tổng lũy thừa bậc 3 = " + sum);
                    }
                    break;
                case 6:
                    System.out.println("Tạm biệt");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại");

            }
        } while (choice != 6);
    }
}
