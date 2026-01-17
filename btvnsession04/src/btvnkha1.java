import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click thes <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class btvnkha1 {
    public static final String VALID_EMAIL_ADDRESS_REGEX =
            "^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,6}$";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        email = email.trim();
        Pattern pattern = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX);
        Matcher matcher = pattern.matcher(email);
        boolean match = matcher.matches();
        if (match) {
            System.out.println("Email address is valid");
        } else  {
            System.out.println("Email address is invalid");
        }
    }
}