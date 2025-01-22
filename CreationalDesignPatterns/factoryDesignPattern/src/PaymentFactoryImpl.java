import custom.PaymentType;
import customExceptions.PaymentException;
import model.CreditCardDetailsDTO;
import model.PayPalDetailsDTO;

public class PaymentFactoryImpl implements PaymentFactory{
    @Override
    public Payment createPayment(PaymentType type, Object paymentDetails) throws PaymentException {
        return switch (type) {
            case CREDIT_CARD -> {
                if (!(paymentDetails instanceof CreditCardDetailsDTO)) {
                    throw new PaymentException("Invalid payment details for Credit Card");
                }
                yield new CreditCardPayment((CreditCardDetailsDTO) paymentDetails);
            }
            case PAYPAL -> {
                if (!(paymentDetails instanceof PayPalDetailsDTO)) {
                    throw new PaymentException("Invalid payment details for PayPal");
                }
                yield new PayPalPayment((PayPalDetailsDTO) paymentDetails);
            }
            default -> throw new PaymentException("Unsupported payment type");
        };
    }
}
