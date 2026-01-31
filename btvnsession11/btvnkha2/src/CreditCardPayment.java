public class CreditCardPayment extends Payment implements Refundable {
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("CreditCardPayment pay " + getAmount());
    }

    @Override
    public void refund() {
        System.out.println("CreditCardPayment refund ");
    }
}

