import custom.PaymentStatus;
import customExceptions.PaymentException;

public class CreditCardPayment implements Payment{
    @Override
    public boolean validatePayment() throws PaymentException {
        return false;
    }

    @Override
    public PaymentStatus processPayment(double amount) throws PaymentException {
        return null;
    }

    @Override
    public PaymentStatus refundPayment(String transactionId) throws PaymentException {
        return null;
    }

    @Override
    public PaymentStatus getPaymentStatus(String transactionId) {
        return null;
    }
}
