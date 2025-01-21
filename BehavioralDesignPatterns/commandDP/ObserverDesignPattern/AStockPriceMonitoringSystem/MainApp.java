package BehavioralDesignPatterns.commandDP.ObserverDesignPattern.AStockPriceMonitoringSystem;

import BehavioralDesignPatterns.commandDP.ObserverDesignPattern.AStockPriceMonitoringSystem.clients.DesktopClient;
import BehavioralDesignPatterns.commandDP.ObserverDesignPattern.AStockPriceMonitoringSystem.clients.MobileClient;
import BehavioralDesignPatterns.commandDP.ObserverDesignPattern.AStockPriceMonitoringSystem.clients.WebClient;

public class MainApp {
    public static void main(String[] args) {
        //Create the StockMarket object
        StockMarket stockMarket = new StockMarket();

        //Create the observers
        Observer mobileClient = new MobileClient();
        Observer webClient = new WebClient();
        Observer desktopClient = new DesktopClient();

        //Register the observers for specific stocks
        stockMarket.registerObserver(mobileClient, "Microsoft");
        stockMarket.registerObserver(webClient, "Apple");
        stockMarket.registerObserver(desktopClient, "Google");

        //Update the stock market
        stockMarket.setPrice("Microsoft", 100);
        stockMarket.setPrice("Apple", 200);
        stockMarket.setPrice("Google", 300);

        //Unregister the observers for specific stocks
        stockMarket.removeObserver(mobileClient, "Microsoft");

        //Set a new stock price
        stockMarket.setPrice("Apple", 4000);


/*        //Register the observers
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
        stockMarket.setStocks("Apple", 400);*/
    }
}
