import java.util.ArrayList;
import java.util.List;

public class TradingEngineApp {
    public static void main(String[] args) {
        List<TradeEvent> eventQueue = new ArrayList<>();

        eventQueue.add(new FIXOrderEvent("EVT-101", "ORD_8921", 500));
        eventQueue.add(new ReutersQuoteEvent("EVT-102", "AAPL", 175.50));
        eventQueue.add(new FIXOrderEvent("EVT-103", "ORD_8922", 1200));

        System.out.println("=== Financial CEP Engine Execution Log ===");
        for (TradeEvent event : eventQueue) {
            System.out.print("[Time: " + event.getTimestamp() + "] ");
            event.processEvent();
        }
    }
}