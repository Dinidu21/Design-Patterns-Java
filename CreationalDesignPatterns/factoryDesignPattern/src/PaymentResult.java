import custom.PaymentStatus;

public record PaymentResult(String transactionId, PaymentStatus paymentStatus) {

    @Override
    public String toString() {
        return "PaymentResult{" +
                "transactionId='" + transactionId + '\'' +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
