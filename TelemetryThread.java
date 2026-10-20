public class TelemetryThread extends Thread {
    public TelemetryThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + getName() + "] System CPU & Memory Health Metrics OK (Iteration " + i + "/5)");
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                System.err.println("Telemetry Thread Interrupted: " + e.getMessage());
            }
        }
    }
}