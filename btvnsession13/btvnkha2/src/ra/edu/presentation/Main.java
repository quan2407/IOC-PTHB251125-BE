package ra.edu.presentation;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        run(sc);
    }
    public static void run(Scanner scanner) {
        StudentView.showMenu(scanner);
    }
}