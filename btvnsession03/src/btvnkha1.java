import java.util.Arrays;
import java.util.Scanner;

public class btvnkha1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Nhập phần tử thứ " + i + ":");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]<arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println("Mảng sau khi giảm dần: ");
        System.out.println(Arrays.toString(arr));
    }
}
