package factory;

import custom.PaymentStatus;
import customExceptions.PaymentException;

public interface Payment {
    boolean validatePayment() throws PaymentException;
    PaymentResult processPayment(double amount) throws PaymentException;
    PaymentStatus refundPayment(String transactionId) throws PaymentException;
}
