package ObserverDesignPattern.StockPriceMonitoringSystem;

public class DesktopClient implements Observer {
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Desktop Client - Stock: " + stockName + " updated to $" + stockPrice);
    }
}
