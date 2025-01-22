import custom.PaymentType;
import customExceptions.PaymentException;

public interface PaymentFactory {
    Payment createPayment(PaymentType type, Object paymentDetails) throws PaymentException;
}
