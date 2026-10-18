public class ReutersQuoteEvent extends TradeEvent {
    private double bidPrice;
    private double askPrice;

    public ReutersQuoteEvent(String senderId, long timestamp, double basePrice, double bidPrice, double askPrice) {
        super(senderId, timestamp, basePrice);
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
    }

    @Override
    public void dispatch() {
        double spread = askPrice - bidPrice;
        System.out.println("[Reuters Quote Adapter] Market Analytics:");
        System.out.println("   Sender: " + senderId + " | Time: " + timestamp);
        System.out.println("   Bid Price: $" + bidPrice + " | Ask Price: $" + askPrice);
        System.out.println("   Bid-Ask Spread: $" + String.format("%.2f", spread));
    }
}