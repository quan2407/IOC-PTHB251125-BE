import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();
        CashPayment cashPayment = new CashPayment(4000);
        payments.add(cashPayment);
        CreditCardPayment creditCardPayment = new CreditCardPayment(4000);
        payments.add(creditCardPayment);
        EWalletPayment eWalletPayment = new EWalletPayment(4000);
        payments.add(eWalletPayment);
        for( Payment payment : payments){
            payment.pay();
            if (payment instanceof Refundable){
                ((Refundable) payment).refund();
            }
        }
    }
}