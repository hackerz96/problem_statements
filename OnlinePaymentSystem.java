// Abstract Payment class
abstract class Payment {
    double amount;
    String transactionId;

    public Payment(double amount, String transactionId) {
        this.amount = amount;
        this.transactionId = transactionId;
    }

    // Abstract method to be implemented by subclasses
    abstract void processPayment();

    // Concrete method to show transaction details
    public void showTransactionDetails() {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Amount: $" + amount);
    }
}

// Subclass for Credit Card payment
class CreditCardPayment extends Payment {
    String cardNumber;
    String CVV;
    String expiryDate;

    public CreditCardPayment(double amount, String transactionId, String cardNumber, String CVV, String expiryDate) {
        super(amount, transactionId);
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.expiryDate = expiryDate;
    }

    @Override
    void processPayment() {
        System.out.println("Processing Credit Card payment...");
        System.out.println("Card Number: **** **** **** " + cardNumber.substring(cardNumber.length() - 4));
        showTransactionDetails();
    }
}

// Subclass for PayPal payment
class PayPalPayment extends Payment {
    String email;
    String password;

    public PayPalPayment(double amount, String transactionId, String email, String password) {
        super(amount, transactionId);
        this.email = email;
        this.password = password;
    }

    @Override
    void processPayment() {
        System.out.println("Processing PayPal payment...");
        System.out.println("PayPal Email: " + email);
        showTransactionDetails();
    }
}

// Subclass for UPI payment
class UPIPayment extends Payment {
    String upiId;

    public UPIPayment(double amount, String transactionId, String upiId) {
        super(amount, transactionId);
        this.upiId = upiId;
    }

    @Override
    void processPayment() {
        System.out.println("Processing UPI payment...");
        System.out.println("UPI ID: " + upiId);
        showTransactionDetails();
    }
}

// Payment Gateway class to handle dynamic payments
class PaymentGateway {
    public void executePayment(Payment payment) {
        payment.processPayment();
        System.out.println("Payment processed successfully!\n");
    }
}

// Main class
public class OnlinePaymentSystem {
    public static void main(String[] args) {
        PaymentGateway gateway = new PaymentGateway();

        Payment creditCardPayment = new CreditCardPayment(250.0, "TXN1001", "1234567890123456", "123", "12/25");
        Payment paypalPayment = new PayPalPayment(100.0, "TXN1002", "user@example.com", "securePassword");
        Payment upiPayment = new UPIPayment(50.0, "TXN1003", "user@upi");

        gateway.executePayment(creditCardPayment);
        gateway.executePayment(paypalPayment);
        gateway.executePayment(upiPayment);
    }
}
