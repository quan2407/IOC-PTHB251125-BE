public class CheckAmstrong {
    public static void main(String[] args) {
        int n =153;
        int temp = n;
        int sum = 0;
        while(temp>0){
            int ch = temp % 10;
            sum = sum + ch*ch*ch;
            temp /= 10;
        }
        if(sum==n){
            System.out.println("Amstrong");
        }
    }
}
