import custom.PaymentStatus;
import customExceptions.PaymentException;
import model.PayPalDetailsDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PayPalPayment implements Payment{
    private PayPalDetailsDTO payPalDetails;
    private Map<String, PaymentStatus> transactions;

    public PayPalPayment(PayPalDetailsDTO payPalDetails) {
        this.payPalDetails = payPalDetails;
        this.transactions = new HashMap<>();
    }

    @Override
    public boolean validatePayment() throws PaymentException {
        if (!payPalDetails.isValid()) {
            throw new PaymentException("Invalid PayPal details");
        }
        return true;
    }

    @Override
    public PaymentStatus processPayment(double amount) throws PaymentException {
        if (amount <= 0) {
            throw new PaymentException("Invalid amount");
        }

        if (validatePayment()) {
            String transactionId = generateTransactionId();
            // Process payment with PayPal API
            PaymentStatus paymentStatus = processWithPayPalAPI(amount);
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

        // Process refund with PayPal API
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

    private PaymentStatus processWithPayPalAPI(double amount) {
        // Real implementation would integrate with PayPal API
        return PaymentStatus.SUCCESSFUL;
    }
}
