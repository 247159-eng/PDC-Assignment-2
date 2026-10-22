import java.util.Random;

public class SensorGridMonitorApp {
    public static void main(String[] args) {
        int gridSize = 100000;
        double[] sensorArray = new double[gridSize];
        Random rand = new Random(101);

        for (int i = 0; i < gridSize; i++) {
            sensorArray[i] = -50.0 + (rand.nextDouble() * 200.0);
        }

        System.out.println("=== IoT Sensor Grid Parallel Search Engine ===");
        System.out.println("Generated " + gridSize + " Sensor Temperature/Vibration Readings.\n");

        int mid = gridSize / 2;

        // Partitioning 4 worker tasks across 2 halves
        ParallelMinSearch minTask1 = new ParallelMinSearch(sensorArray, 0, mid);
        ParallelMinSearch minTask2 = new ParallelMinSearch(sensorArray, mid, gridSize);
        ParallelMaxSearch maxTask1 = new ParallelMaxSearch(sensorArray, 0, mid);
        ParallelMaxSearch maxTask2 = new ParallelMaxSearch(sensorArray, mid, gridSize);

        Thread t1 = new Thread(minTask1, "Min-Worker-1");
        Thread t2 = new Thread(minTask2, "Min-Worker-2");
        Thread t3 = new Thread(maxTask1, "Max-Worker-1");
        Thread t4 = new Thread(maxTask2, "Max-Worker-2");

        long startTime = System.nanoTime();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double globalMin = Math.min(minTask1.getMinValue(), minTask2.getMinValue());
        double globalMax = Math.max(maxTask1.getMaxValue(), maxTask2.getMaxValue());

        long endTime = System.nanoTime();
        double durationMs = (endTime - startTime) / 1e6;

        System.out.println("=== Parallel Grid Reduction Results ===");
        System.out.println("Global Minimum Reading : " + String.format("%.2f", globalMin) + " °C");
        System.out.println("Global Maximum Reading : " + String.format("%.2f", globalMax) + " °C");
        System.out.println("Parallel Search Duration: " + String.format("%.3f", durationMs) + " ms");
    }
}