public class TradingEngineApp {
    public static void main(String[] args) {
        System.out.println("=== CEP Engine Market Event Dispatcher ===");

        // Polymorphic assignment: Superclass references holding subclass instances
        TradeEvent fixOrder = new FIXOrderEvent("FIX_GATEWAY_01", System.currentTimeMillis(), 2500.50, "ORD_1001");
        TradeEvent reutersQuote = new ReutersQuoteEvent("REUTERS_FEED_02", System.currentTimeMillis(), 2500.50, 2498.00, 2502.50);

        // Runtime dynamic method overriding
        System.out.println("\n--- Dispatching FIX Order Event ---");
        fixOrder.dispatch();

        System.out.println("\n--- Dispatching Reuters Quote Event ---");
        reutersQuote.dispatch();
    }
}