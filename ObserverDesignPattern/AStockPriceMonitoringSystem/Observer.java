package ObserverDesignPattern.AStockPriceMonitoringSystem;

/**
 * An interface for objects that want to be notified of stock price updates.
 *
 * @author Dinidu21
 */
public interface Observer {
    /**
     * Notifies the observer of a stock price update.
     *
     * @param stockName the name of the stock that has updated
     * @param stockPrice the new price of the stock
     */
    void update(String stockName, double stockPrice);
}
