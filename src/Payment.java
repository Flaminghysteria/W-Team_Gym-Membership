public class Payment extends Admin {
    private int paymentId;
    private double amount;
    private String paymentDate;
    private String method;

    public Payment(String name, String email, String phone, String username, String password, int paymentId, double amount, String paymentDate, String method) {
        super(name, email, phone, username, password);
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.method = method;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getMethod() {
        return method;
    }

    public boolean hasPaid() {
        return false;
    }
}
