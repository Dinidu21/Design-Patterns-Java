package BehavioralDesignPatterns.commandDP.ObserverDesignPattern.StockPriceMonitoringSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a stock market that allows observers to register and receive updates on stock prices.
 */
public class StockMarket implements Subject {
    /**
     * List of observers registered to receive updates on stock prices.
     */
    private List<Observer> observers;

    /**
     * Map of stock names to their current prices.
     */
    private Map<String, Double> stocks;


    /**
     * Constructs a new StockMarket instance.
     */
    public StockMarket() {
        this.observers = new ArrayList<>();
        this.stocks = new HashMap<>();
    }

    /**
     * Registers an observer to receive updates on stock prices.
     *
     * @param o Observer to register
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Removes an observer from receiving updates on stock prices.
     *
     * @param o Observer to remove
     */
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Notifies all registered observers of an update on a stock price.
     *
     * @param stockName Name of the stock that was updated
     * @param stockPrice New price of the stock
     */
    @Override
    public void notifyObservers(String stockName, double stockPrice) {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }

    /**
     * Sets the price of a stock and notifies all registered observers of the update.
     *
     * @param stockName Name of the stock to update
     * @param stockPrice New price of the stock
     */
    public void setStocks(String stockName, double stockPrice) {
        stocks.put(stockName, stockPrice);
        notifyObservers(stockName, stockPrice);
    }

    /**
     * Retrieves the current price of a stock.
     *
     * @param stockName Name of the stock to retrieve the price for
     * @return Current price of the stock, or 0.0 if the stock is not found
     */
    public double getStockPrice(String stockName) {
        return stocks.getOrDefault(stockName, 0.0);
    }
}