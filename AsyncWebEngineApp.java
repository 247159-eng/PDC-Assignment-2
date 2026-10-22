public class AsyncWebEngineApp {
    public static void main(String[] args) {
        System.out.println("JVM Default Thread: " + Thread.currentThread().getName());

        TelemetryThread telemetryWorker = new TelemetryThread("Telemetry-Worker");
        Thread logWorker = new Thread(new LogProcessorTask(), "Log-Worker");

        System.out.println("Spawning concurrent worker threads...");
        System.out.println("  " + telemetryWorker.getName() + " Initial State: " + telemetryWorker.getState());
        System.out.println("  " + logWorker.getName() + " Initial State: " + logWorker.getState());

        telemetryWorker.start();
        logWorker.start();

        try {
            telemetryWorker.join();
            logWorker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All asynchronous background tasks successfully completed.");
    }
}