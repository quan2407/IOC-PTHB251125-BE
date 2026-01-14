import java.util.Scanner;

public class btvnkha2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số hàng của mảng: ");
        int row = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số cột của mảng: ");
        int col = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.printf("Phần tử [%d][%d]: ",i,j);
                arr[i][j]=Integer.parseInt(sc.nextLine());
            }
        }
        int evenSum=0;
        int oddSum=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]%2==0){
                    evenSum+=arr[i][j];
                } else {
                    oddSum+=arr[i][j];
                }
            }
        }
        System.out.println("Tổng các số chẵn: " + evenSum);
        System.out.println("Tổng các số lẻ: " + oddSum);
    }
}
