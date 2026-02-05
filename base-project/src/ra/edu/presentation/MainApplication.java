package ra.edu.presentation;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        run(sc);
    }
    public static void run(Scanner scanner) {
        StudentView.showMenu(scanner);
    }
}
