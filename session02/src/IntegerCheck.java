import java.util.Scanner;

public class IntegerCheck {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số a: ");
        int a = Integer.parseInt(sc.nextLine());
        while (a<0){
            System.out.println(RED + "Số " + a + " là số âm, vui lòng nhập lại" + RESET);
            System.out.println("Nhập số a: ");
            a = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Số vừa nhập là " + a);
    }
}
