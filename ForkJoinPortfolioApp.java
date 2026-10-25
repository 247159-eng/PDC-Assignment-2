import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPortfolioApp {
    public static void main(String[] args) {
        int size = 10000;
        double[] assets = new double[size];
        Random random = new Random(42);

        for (int i = 0; i < size; i++) {
            assets[i] = 100 + random.nextDouble() * 900;
        }

        try (ForkJoinPool pool = new ForkJoinPool()) {
            long startTime = System.nanoTime();

            ParallelRiskCalculator riskTask = new ParallelRiskCalculator(assets, 0, assets.length);
            double totalRisk = pool.invoke(riskTask);

            double riskCap = 800.0;
            PortfolioThresholdTask thresholdTask = new PortfolioThresholdTask(assets, 0, assets.length, riskCap);
            pool.invoke(thresholdTask);

            ParallelRiskCalculator postRiskTask = new ParallelRiskCalculator(assets, 0, assets.length);
            double postTotalRisk = pool.invoke(postRiskTask);

            long endTime = System.nanoTime();
            double elapsedTimeMs = (endTime - startTime) / 1e6;

            System.out.println("=== Fork/Join Asset Portfolio Engine ===");
            System.out.println("Sequential Processing Threshold: " + ParallelRiskCalculator.getThreshold());
            System.out.println("Synthetic Assets Generated: " + size);
            System.out.println("Initial Cumulative Risk Score: $" + String.format("%.2f", totalRisk));
            System.out.println("Risk Cap Threshold: $" + riskCap + " (Applied 5% Volatility Stress Penalty)");
            System.out.println("Post-Stress Cumulative Risk Score: $" + String.format("%.2f", postTotalRisk));
            System.out.println("Parallel Processing Time: " + String.format("%.3f", elapsedTimeMs) + " ms");
        }
    }
}