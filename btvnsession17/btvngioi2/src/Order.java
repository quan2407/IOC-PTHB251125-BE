class Order {
    int id; int customerId; String orderDate; double totalAmount;
    public Order(int customerId, double totalAmount) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
    }
}