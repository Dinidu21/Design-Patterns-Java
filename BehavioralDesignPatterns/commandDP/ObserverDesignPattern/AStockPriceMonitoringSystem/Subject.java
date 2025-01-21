package BehavioralDesignPatterns.commandDP.ObserverDesignPattern.AStockPriceMonitoringSystem;

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
    void registerObserver(Observer o, String stockName);  // Register for a specific stock
    /**
     * Remove an observer (client) so they no longer receive updates.
     *
     * @param o The observer (client) to be removed.
     */
    void removeObserver(Observer o, String stockName);    // Unregister from a specific stock

    /**
     * Notify all observers that are subscribed to the specified stock with the latest price update.
     *
     * @param stockName the name of the stock being updated
     * @param newPrice the new price of the stock
     */
    void notifyObservers(String stockName, double newPrice);  // Notify only those subscribed to this stock
}