public class FIXOrderEvent extends TradeEvent {
    private String clOrdId;

    public FIXOrderEvent(String senderId, long timestamp, double basePrice, String clOrdId) {
        super(senderId, timestamp, basePrice);
        this.clOrdId = clOrdId;
    }

    @Override
    public void dispatch() {
        double fee = basePrice * 0.0015; // 0.15% transaction fee
        double totalPrice = basePrice + fee;
        System.out.println("[FIX Gateway Adapter] Stock Purchase Executed:");
        System.out.println("   Order ID: " + clOrdId + " | Sender: " + senderId);
        System.out.println("   Base Price: $" + basePrice + " | Fee (0.15%): $" + String.format("%.2f", fee) + " | Total: $" + String.format("%.2f", totalPrice));
    }
}
