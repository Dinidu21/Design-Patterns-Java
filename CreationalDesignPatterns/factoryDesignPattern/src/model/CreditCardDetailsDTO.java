package model;

public class CreditCardDetailsDTO {
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String cardHolderName;

    public CreditCardDetailsDTO() {
    }

    public CreditCardDetailsDTO(String cardNumber, String expiryDate, String cvv, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.cardHolderName = cardHolderName;
    }

    public boolean isValid() {
        return cardNumber != null && cardNumber.length() == 16 &&
                cvv != null && cvv.length() == 3 &&
                expiryDate != null && expiryDate.matches("\\d{2}/\\d{2}") &&
                cardHolderName != null && !cardHolderName.trim().isEmpty();
    }
}
