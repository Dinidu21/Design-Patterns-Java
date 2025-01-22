import custom.PaymentStatus;
import customExceptions.PaymentException;

public interface Payment {
    boolean validatePayment() throws PaymentException;
    PaymentStatus processPayment(double amount) throws PaymentException;
    PaymentStatus refundPayment(String transactionId) throws PaymentException;
    PaymentStatus getPaymentStatus(String transactionId);
}
