package payment;

import custom.PaymentStatus;
import customExceptions.PaymentException;
import factory.Payment;
import factory.PaymentResult;
import model.PayPalDetailsDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PayPalPayment implements Payment {
    private final PayPalDetailsDTO payPalDetails;
    private final Map <String, PaymentStatus> transactions;

    public PayPalPayment(PayPalDetailsDTO payPalDetails) {
        this.payPalDetails = payPalDetails;
        transactions = new HashMap<>();
    }

    @Override
    public boolean validatePayment() throws PaymentException {
        if (!payPalDetails.isValid()) {
            throw new PaymentException("Invalid PayPal details");
        }
        return true;
    }

    @Override
    public PaymentResult processPayment(double amount) throws PaymentException {
        if (amount <= 0) {
            throw new PaymentException("Invalid amount");
        }

        if (validatePayment()) {
            String transactionId = generateTransactionId();
            // Process payment with PayPal API
            PaymentStatus paymentStatus = processWithPayPalAPI(amount);
            transactions.put(transactionId, paymentStatus);

            System.out.println("\nfactory.Payment Type   : "+getClass().getName());
            System.out.println("factory.Payment Status : " + paymentStatus);
            System.out.println("Transaction Id : " + transactionId);

            return new PaymentResult(transactionId, paymentStatus);
        }

        return new PaymentResult(null, PaymentStatus.FAILED);
    }

    @Override
    public PaymentStatus refundPayment(String transactionId) throws PaymentException {
        if(!transactions.containsKey(transactionId)){
            throw new PaymentException("Invalid transaction ID Or Transaction not found");
        }

        if(transactions.get(transactionId) != PaymentStatus.SUCCESSFUL){
            throw new PaymentException("Cannot refund unsuccessful transaction");
        }

        // Process refund with PayPal API
        transactions.put(transactionId, PaymentStatus.REFUNDED);
        return PaymentStatus.REFUNDED;
    }

    private String generateTransactionId() {
        return UUID.randomUUID().toString();
    }

    private PaymentStatus processWithPayPalAPI(double amount) {
        // Real implementation would integrate with PayPal API
        return PaymentStatus.SUCCESSFUL;
    }
}
