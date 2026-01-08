import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập cân nặng(kg): ");
        double weight = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập chiều cao(m): ");
        double height = Double.parseDouble(sc.nextLine());
        double bmi = weight / (height * height);
        if (bmi < 16) {
            System.out.println("Gầy độ 3");

        } else if (bmi >= 16 && bmi <= 16.9) {
            System.out.println("Gầy độ 2");
        } else if (bmi >= 17 && bmi < 18.4) {
            System.out.println("Gầy độ 1");
        } else if (bmi >= 18.4 && bmi <= 24.9) {
            System.out.println("Bình thường");
        }  else if (bmi >= 25 && bmi <= 29.9) {
            System.out.println("Tiền béo phì (Thừa cân)");
        }  else if (bmi >= 30 && bmi <= 34.9) {
            System.out.println("Béo phì độ I");
        }   else if (bmi >= 35 && bmi <= 39.9) {
            System.out.println("Béo phì độ II");
        }   else {
            System.out.println("Béo phì độ III");
        }
    }

}
