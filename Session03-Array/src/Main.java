import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        // Khai báo mảng số nguyên có 10 phần tử
//        int [] arrInt = new int [10];
//        arrInt[0] = 1;
//        arrInt[1] = 2;
//        int [] arrInt2 = {1,2,3,4,5};
//
//        // 2 thành phần của mảng: phần tử, vị trí
//        // lấy phần tử duựa theo vị trí
//        System.out.println("Phan tu tai index =2 la : " + arrInt[2]);
//        arrInt[2] = 100;
//        System.out.println("Phan tu tai index =2 la : " + arrInt[2]);
//
//        // Mảng 2 chiều
//        int[][] arr2D = new int [10][10];
//        arr2D[0][0] = 1;
//        int [][] arr2D2 = {{1,2},{3,4},{5,6}};
//
//        for (int i = 0; i < arrInt2.length; i++) {
//            System.out.println("Array[i] = " + arrInt2[i]);
//        }
//        for (int i = 0; i < arr2D.length; i++) {
//            for (int j = 0; j < arr2D[i].length; j++) {
//                System.out.println("Array[j] = " + arr2D[i][j]);
//            }
//        }

        // Tạo mảng lưu trữ danh sách điểm thi của 10 môn học
        Scanner sc = new Scanner(System.in);
        double[] ketquakiemtra = new double [10];
        for (int i = 0; i < ketquakiemtra.length; i++) {
            System.out.print("ketquakiemtra[" + i + "] = ");
            ketquakiemtra[i] = sc.nextDouble();
        }

        double average = 0;
        double max = ketquakiemtra[0];
        double min = ketquakiemtra[0];
        for (int i = 0; i < ketquakiemtra.length; i++) {
            average += ketquakiemtra[i];
            if (ketquakiemtra[i] > max) {
                max = ketquakiemtra[i];
            }
            if (ketquakiemtra[i] < min) {
                min = ketquakiemtra[i];
            }
        }
        average = average / ketquakiemtra.length;
        System.out.println("average is " + average);
        System.out.println("max is " + max);
        System.out.println("min is " + min);
        // Duyệt mảng thực hiện tính : Điểm trung bình, didểm cao, thấp của sinh viên
    }
}
