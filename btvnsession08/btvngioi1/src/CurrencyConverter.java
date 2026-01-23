import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyConverter {
    private static double rate = 27000;
    public static void setRate(Double r) {
        if (r != null && r > 0) {
            rate = r;
        } else {
            System.out.println("Tỉ giá không hợp lệ");
        }
    }
    public static double getRate() {
        return rate;
    }
    public static double toUSD(int vnd) {
        return (double) vnd / rate;
    }

    public static String formatUsd(Double amount, int scale) {
        if (amount == null) {
            return "Tiền nhập vào không hợp lệ";
        }
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        nf.setRoundingMode(RoundingMode.HALF_UP);
        nf.setMinimumFractionDigits(scale);
        nf.setMaximumFractionDigits(scale);
        return nf.format(amount);
    }
}
