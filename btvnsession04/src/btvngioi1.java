import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click thes <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class btvngioi1 {
    public static final String VALID_EMAIL_ADDRESS_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$!%])[A-Za-z\\d@#$!%]{8,}$";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        Pattern pattern = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX);
        Matcher matcher = pattern.matcher(password);
        boolean match = matcher.matches();
        if (match) {
            System.out.println("Password is valid");
        } else  {
            System.out.println("Password is invalid");
        }
    }
}