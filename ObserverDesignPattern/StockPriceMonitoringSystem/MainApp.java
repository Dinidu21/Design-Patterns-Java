package ObserverDesignPattern.StockPriceMonitoringSystem;

public class MainApp {
    public static void main(String[] args) {
        //Create the StockMarket object
        StockMarket stockMarket = new StockMarket();

        //Create the observers
        Observer mobileClient = new MobileClient();
        Observer webClient = new WebClient();
        Observer desktopClient = new DesktopClient();

        //Register the observers
        stockMarket.registerObserver(mobileClient);
        stockMarket.registerObserver(webClient);
        stockMarket.registerObserver(desktopClient);

        //Update the stock market
        stockMarket.setStocks("Apple", 100);
        stockMarket.setStocks("Microsoft", 200);
        stockMarket.setStocks("Google", 300);

        //Unregister the observers
        stockMarket.removeObserver(mobileClient);

        //Set a new stock price
        stockMarket.setStocks("Apple", 400);
    }
}
