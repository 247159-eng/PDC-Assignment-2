public class ParallelMinSearch extends SensorSearchEngine implements Runnable {
    private double minValue = Double.MAX_VALUE;

    public ParallelMinSearch(double[] sensorData, int startIdx, int endIdx) {
        super(sensorData, startIdx, endIdx);
    }
}