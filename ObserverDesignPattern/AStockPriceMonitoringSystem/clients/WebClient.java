package ObserverDesignPattern.AStockPriceMonitoringSystem.clients;

import ObserverDesignPattern.AStockPriceMonitoringSystem.Observer;

/**
 * A web client that implements the Observer interface.
 * It receives updates from the stock market and prints them to the console.
 */
public class WebClient implements Observer {

    /**
     * Updates the web client with the latest stock information.
     *
     * @param stockName the name of the stock
     * @param stockPrice the current price of the stock
     */
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Web Client - Stock: " + stockName + " updated to $" + stockPrice);    }
}
