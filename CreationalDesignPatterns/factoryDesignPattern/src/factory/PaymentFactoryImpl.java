package factory;

import custom.PaymentType;
import customExceptions.PaymentException;
import model.CreditCardDetailsDTO;
import model.PayPalDetailsDTO;
import payment.CreditCardPayment;
import payment.PayPalPayment;

public class PaymentFactoryImpl implements PaymentFactory {
    @Override
    public <T> Payment createPayment(PaymentType type, T paymentDetails) throws PaymentException {
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
