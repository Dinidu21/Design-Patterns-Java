import custom.PaymentStatus;
import customExceptions.PaymentException;
import model.CreditCardDetailsDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CreditCardPayment implements Payment{
    private CreditCardDetailsDTO cardDetails;
    private Map<String,PaymentStatus> transactions;

    public CreditCardPayment(CreditCardDetailsDTO cardDetails) {
        this.cardDetails = cardDetails;
        this.transactions = new HashMap<>();
    }


    @Override
    public boolean validatePayment() throws PaymentException {
        if(!cardDetails.isValid()){
            throw new PaymentException("Invalid card details");
        }
        // Additional validation logic (Luhn algorithm, etc.)
        return true;
    }

    @Override
    public PaymentStatus processPayment(double amount) throws PaymentException {
        if(amount <= 0){
            throw new PaymentException("Invalid amount");
        }

        if(validatePayment()){
            String transactionId = generateTransactionId();
            // Process payment with credit card gateway
            PaymentStatus paymentStatus = processWithGateway(amount);
            transactions.put(transactionId, paymentStatus);
            return paymentStatus;
        }

        return PaymentStatus.FAILED;
    }

    @Override
    public PaymentStatus refundPayment(String transactionId) throws PaymentException {
        if(!transactions.containsKey(transactionId)){
            throw new PaymentException("Invalid transaction ID Or Transaction not found");
        }

        if(transactions.get(transactionId) != PaymentStatus.SUCCESSFUL){
            throw new PaymentException("Cannot refund unsuccessful transaction");
        }

        // Process refund with gateway
        transactions.put(transactionId, PaymentStatus.REFUNDED);
        return PaymentStatus.REFUNDED;
    }

    @Override
    public PaymentStatus getPaymentStatus(String transactionId) {
        return transactions.getOrDefault(transactionId, PaymentStatus.PENDING);
    }

    private String generateTransactionId() {
        return UUID.randomUUID().toString();
    }

    private PaymentStatus processWithGateway(double amount) {
        // Real implementation would integrate with a payment gateway
        return PaymentStatus.SUCCESSFUL;
    }
}
