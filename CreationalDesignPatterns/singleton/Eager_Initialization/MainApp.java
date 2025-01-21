package singleton.Eager_Initialization; 

class CreditCard {
    // Eagerly create the singleton instance
    private static final CreditCard creditCard = new CreditCard();

    // Private constructor to prevent instantiation
    private CreditCard() {}

    // Static method to provide access to the instance
    public static CreditCard getInstance() {
        return creditCard;
    }

    public boolean validate(String cardNo, int code) {
        return cardNo.length() == 16 && code % 3 == 0;
    }
}
public class MainApp{
    public static void main(String[] args) {
        CreditCard card1 = CreditCard.getInstance();
        CreditCard card2 = CreditCard.getInstance();
        System.out.println(card1.validate("1032112109311801", 300));
        System.out.println(card2.validate("5032112109311801", 910));

    }
}