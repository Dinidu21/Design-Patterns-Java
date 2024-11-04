package ObserverDesignPattern.StockPriceMonitoringSystem;

public class MobileClient implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Mobile Client - Stock: " + stockName + " updated to $" + stockPrice);
    }
}
