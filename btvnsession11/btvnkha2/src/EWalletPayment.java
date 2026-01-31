public class EWalletPayment extends Payment implements Refundable{
    public EWalletPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("EWalletPayment " + getAmount());
    }

    @Override
    public void refund() {
        System.out.println("EWalletPayment refund ");
    }
}
