public class ParallelMaxSearch extends SensorSearchEngine implements Runnable {
    private double maxValue = Double.MIN_VALUE;

    public ParallelMaxSearch(double[] sensorData, int startIdx, int endIdx) {
        super(sensorData, startIdx, endIdx);
    }

    @Override
    public double processGrid() {
        double localMax = Double.MIN_VALUE;
        for (int i = startIdx; i < endIdx; i++) {
            if (sensorData[i] > localMax) {
                localMax = sensorData[i];
            }
        }
        return localMax;
    }

    @Override
    public void run() {
        this.maxValue = processGrid();
    }

    public double getMaxValue() {
        return maxValue;
    }
}