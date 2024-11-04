package ObserverDesignPattern.StockPriceMonitoringSystem;

public class WebClient implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Web Client - Stock: " + stockName + " updated to $" + stockPrice);    }
}
