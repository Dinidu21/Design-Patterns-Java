import custom.PaymentType;
import customExceptions.PaymentException;

public interface PaymentFactory {
    <T> Payment createPayment(PaymentType type, T paymentDetails) throws PaymentException;
}
