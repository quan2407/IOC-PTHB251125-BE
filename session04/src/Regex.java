import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static final String VALID_EMAIL_ADDRESS_REGEX =
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    public static void main(String[] args) {
        //Cach1
        Pattern pattern = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX);
        Matcher matcher = pattern.matcher("hunghxx@gmail.com");
        boolean matchFound = matcher.matches();
        //Cach2
        boolean isMatch = Pattern.matches(VALID_EMAIL_ADDRESS_REGEX, "hunghx@gmail.com".toUpperCase());
        //Cach3
        boolean isMatch2 = "hunghx@gmail.com".toUpperCase().matches(VALID_EMAIL_ADDRESS_REGEX);
    }

}

