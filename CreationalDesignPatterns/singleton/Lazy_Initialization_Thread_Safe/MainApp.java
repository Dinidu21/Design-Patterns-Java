package singleton.Lazy_Initialization_Thread_Safe;
class CreditCard {
    private static CreditCard creditCard = null;

    // Private constructor to prevent instantiation
    private CreditCard() {}

    // Static method to provide access to the instance
    public static synchronized CreditCard getInstance() {
        if (creditCard == null) {
            creditCard = new CreditCard(); // Instance created only when needed
        }
        return creditCard;
    }

    public boolean validate(String cardNo, int code) {
        return cardNo.length() == 16 && code % 3 == 0;
    }
}
    class MainApp{
        public static void main(String[] args) {
            CreditCard card1 = CreditCard.getInstance();
            CreditCard card2 = CreditCard.getInstance();
            System.out.println(card1.validate("1032112109311801", 300));
            System.out.println(card2.validate("5032112109311801", 981));
    
        }
    }
