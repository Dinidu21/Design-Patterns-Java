## A Stock Price Monitoring System
Stock price monitoring system for a stock market. The system should allow different clients to subscribe to stock price updates for specific stocks they are interested in. Whenever a stock's price changes, all subscribed clients should be notified immediately.
Requirements:

Subject (Observable): The StockMarket class acts as the subject, where various stocks are traded. It maintains the current price of multiple stocks.
        You should be able to register, unregister, and notify clients (observers).
        The StockMarket class should have a method to update the price of a specific stock. When this happens, all subscribed clients should be notified of the price change.
Observers: Clients (observers) are notified when there is a change in the stock price they are subscribed to. These clients can be different types of entities, such as:
        MobileClient: A client that receives stock price updates on their mobile app.
        WebClient: A client that receives stock price updates on their web dashboard.
        DesktopClient: A client that receives stock price updates on their desktop application.
Each client should implement the observer interface and should be able to receive and display stock price updates in their respective format.

### Bonus Challenge: Subscribe Clients to Specific Stocks   : Done

To make it more advanced, 
you can allow clients to subscribe to specific stocks only, 
so they only receive updates for stocks they care about. 
You can implement this by modifying the StockMarket 
class to track which observer is interested in which stock.

### Bonus Enhancements : Todo
If you want to enhance this further:
Multiple stock subscriptions: Allow an observer to subscribe to multiple stocks.
    Use a Set<String> inside each observer to store their subscriptions.
Notifications filtering: Implement a filtering mechanism where clients only receive updates 
if the price changes by a significant percentage.