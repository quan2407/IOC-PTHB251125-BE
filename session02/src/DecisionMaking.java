import java.util.Scanner;

public class DecisionMaking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println("Nhap gia tri cua a");
        a = Integer.parseInt(sc.nextLine());
        if (a>0){
            System.out.println("A lon hon 0 !");
        } else if(a>-10){
            System.out.println("A nhỏ hoặc bằng 0 và lớn hơn -10 !");
        } else {
            System.out.println("A nhỏ hơn hoặc bằng -10");
        }
        // toán tử 3 ngôi
        int result = a>0? 0: a>-10 ? 1:2;
        // Switch
        // Biểu thức xét điều kiện phải trả về giá trị : num, numeric, char, string
        switch (a){
            case 0:
            {
                System.out.println("a bằng 0");
                break;
            }
            case 1:
            {
                System.out.println("a bằng 1");
                break;
            }
            default:
                System.out.println("không có trường hợp nào thỏa mãn");
        }
    }
}
