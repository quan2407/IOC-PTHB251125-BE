import java.util.Arrays;
import java.util.Scanner;

public class btvngioi1 {
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
        System.out.print("Nhập số cần tìm: ");
        int findNumber = Integer.parseInt(sc.nextLine());
        boolean isFound = false;
        int foundIndex = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==findNumber){
                foundIndex = i;
                isFound = true;
                break;
            }
        }
        if(isFound){
            System.out.printf("Tìm kiếm tuyến tính: Số %d có tại vị trí %d\n",findNumber,foundIndex);

        } else {
            System.out.println("Không tìm thấy");
        }

        isFound = false;
        foundIndex = -1;
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==findNumber){
                foundIndex = mid;
                isFound = true;
                break;
            } else if(arr[mid]>findNumber){
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        if(isFound){
            System.out.printf("Tìm kiếm nhị phân: Số %d có tại vị trí %d\n",findNumber,foundIndex);

        } else {
            System.out.println("Không tìm thấy");
        }
    }
}
