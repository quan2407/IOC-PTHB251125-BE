import java.util.Arrays;
import java.util.Scanner;

public class btvngioi2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = Integer.parseInt(sc.nextLine());
        if (n<=0){
            System.out.println("Mảng không hợp lệ");
            return;
        }
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Nhập phần tử thứ " + i + ":");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
       int[] result=new int[n];
        for(int i=0;i<n;i++){
            if (arr[i]%2==0){
                result[i]=arr[i];
            }
        }
        for(int i=0;i<n;i++){
            if (result[i]%2!=0){
                result[i]=arr[i];
            }
        }
        System.out.println(Arrays.toString(result));

    }
}
