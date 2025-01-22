import custom.PaymentStatus;
import custom.PaymentType;
import customExceptions.PaymentException;
import model.CreditCardDetailsDTO;
import model.PayPalDetailsDTO;

public class PaymentService {
    public static void main(String[] args)  {
        PaymentFactory paymentFactory = new PaymentFactoryImpl();

        try {
            // Process Credit Card Payment
            CreditCardDetailsDTO cardDetails = new CreditCardDetailsDTO(
                    "1234567890123456",
                    "12/25",
                    "123",
                    "Sachin Rukshan"
            );

            Payment cardPayment = paymentFactory.createPayment(PaymentType.CREDIT_CARD, cardDetails);
            PaymentResult paymentResultsForCard = cardPayment.processPayment(25000.50);
            System.out.println("\n"+paymentResultsForCard);

            if (paymentResultsForCard.paymentStatus() == PaymentStatus.SUCCESSFUL) {
                String transactionId = paymentResultsForCard.transactionId();

                // Refund the payment using the transaction ID
                PaymentStatus refundStatus = cardPayment.refundPayment(transactionId);

                // Handle the refund status
                handleRefundStatus(refundStatus);
            }

            // Process PayPal Payment
            PayPalDetailsDTO paypalDetails = new PayPalDetailsDTO(
                    "dinidu@example.com",
                    "token123"
            );

            Payment paypalPayment = paymentFactory.createPayment(PaymentType.PAYPAL, paypalDetails);
            PaymentResult paymentResult = paypalPayment.processPayment(15000.00);
            System.out.println("\n"+paymentResult);

            if (paymentResult.paymentStatus() == PaymentStatus.SUCCESSFUL) {
                String transactionId = paymentResult.transactionId();

                // Refund the payment using the transaction ID
                PaymentStatus refundStatus = paypalPayment.refundPayment(transactionId);

                // Handle the refund status
                handleRefundStatus(refundStatus);
            }

        } catch (PaymentException e) {
            e.printStackTrace();
        }
    }

    private static void handleRefundStatus(PaymentStatus refundStatus) {
        switch (refundStatus) {
            case REFUNDED:
                // Handle successful refund
                System.out.println("Refund processed successfully");
                break;
            case FAILED:
                // Handle failed refund
                System.out.println("Refund failed");
                break;
            default:
                System.out.println("Unexpected refund status: " + refundStatus);
        }
    }
}
