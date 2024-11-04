package ObserverDesignPattern.StockPriceMonitoringSystem;

/**
 * The Subject interface defines the methods that the Observers use to receive updates from the Subject.
 * It maintains a list of its Observer objects and notifies them when its state changes.
 */
public interface Subject {
    /**
     * Register an observer (client) so they can receive updates.
     *
     * @param o The observer (client) to be registered.
     */
    void registerObserver(Observer o);

    /**
     * Remove an observer (client) so they no longer receive updates.
     *
     * @param o The observer (client) to be removed.
     */
    void removeObserver(Observer o);

    /**
     * Notify all observers (clients) that the subject has changed.
     *
     * @param stockName The name of the stock that has changed.
     * @param stockPrice The new price of the stock.
     */
    void notifyObservers(String stockName, double stockPrice);
}