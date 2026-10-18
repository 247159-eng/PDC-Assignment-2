public class TradeEvent {
    protected String senderId;
    protected long timestamp;
    protected double basePrice;

    // Parameterized Constructor
    public TradeEvent(String senderId, long timestamp, double basePrice) {
        this.senderId = senderId;
        this.timestamp = timestamp;
        this.basePrice = basePrice;
    }

    // Baseline dispatch method
    public void dispatch() {
        System.out.println("[TradeEvent Log] Generic Event Dispatched | Sender: " + senderId + " | Base Price: $" + basePrice);
    }
}
