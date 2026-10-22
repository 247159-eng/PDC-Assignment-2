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
        System.out.println("Generated " + gridSize + " Sensor Temperature/Vibration Readings.");
    }
}