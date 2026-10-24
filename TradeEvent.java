public class TradeEvent {
    protected String senderId;
    protected long timestamp;
    protected double basePrice;

    public TradeEvent(String senderId, long timestamp, double basePrice) {
        this.senderId = senderId;
        this.timestamp = timestamp;
        this.basePrice = basePrice;
    }

    public String getSenderId() {
        return senderId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void dispatch() {
        System.out.println("[TradeEvent Log] Generic Event Dispatched | Sender: " + this.senderId + " 
        | Base Price: $" + this.basePrice + " | Timestamp: " + this.timestamp);
    }
}