package ObserverDesignPattern.StockPriceMonitoringSystem;
/**
 * A desktop client that implements the Observer interface.
 * It receives updates from the stock market and prints them to the console.
 */
public class DesktopClient implements Observer {

    /**
     * Updates the desktop client with the latest stock information.
     *
     * @param stockName the name of the stock
     * @param stockPrice the current price of the stock
     */
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Desktop Client - Stock: " + stockName + " updated to $" + stockPrice);
    }
}
