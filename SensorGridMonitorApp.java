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
    }
}