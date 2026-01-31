public abstract class Payment {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Payment(double amount) {
        this.amount = amount;
    }
    public abstract void pay();
    void printAmount() {
        System.out.println("Amount : " + amount);
    }
}
