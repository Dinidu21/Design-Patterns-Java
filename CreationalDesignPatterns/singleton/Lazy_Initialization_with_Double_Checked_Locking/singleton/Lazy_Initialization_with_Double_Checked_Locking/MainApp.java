package singleton.Lazy_Initialization_with_Double_Checked_Locking;

class CreditCard {
    private static volatile CreditCard creditCard = null;

    // Private constructor to prevent instantiation
    private CreditCard() {}

    // Static method to provide access to the instance
    public static CreditCard getInstance() {
        if (creditCard == null) { // First check (no locking)
            synchronized (CreditCard.class) { // Locking
                if (creditCard == null) { // Second check (with locking)
                    creditCard = new CreditCard(); // Instance created only when needed
                }
            }
        }
        return creditCard;
    }

    public boolean validate(String cardNo, int code) {
        return cardNo.length() == 16 && code % 3 == 0;
    }
}
public class MainApp {
    public static void main(String[] args) {
        CreditCard card1 = CreditCard.getInstance();
        CreditCard card2 = CreditCard.getInstance();
        System.out.println(card1.validate("1032112109311801", 300)); // Should print true
        System.out.println(card2.validate("5032112109311801", 910)); // Should print false
    }
}