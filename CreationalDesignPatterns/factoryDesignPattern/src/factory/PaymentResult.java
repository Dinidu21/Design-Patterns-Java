package factory;

import custom.PaymentStatus;

public record PaymentResult(String transactionId, PaymentStatus paymentStatus) {

    @Override
    public String toString() {
        return "factory.PaymentResult{" +
                "transactionId='" + transactionId + '\'' +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
