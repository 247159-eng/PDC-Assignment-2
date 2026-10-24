public class CacheLocalityBenchmark {
    public static void main(String[] args) {
        System.out.println("=== CPU Cache Locality & Memory Traversal Profiler ===");
        
        int matrixSize = 2000;
        System.out.println("Allocating and initializing 2D Matrix: " + matrixSize + "x" + matrixSize + " (4,000,000 elements)...");
        MatrixProcessor processor = new MatrixProcessor(matrixSize);
        System.out.println("Matrix memory allocation ready.\n");

        // 1. Benchmark Row-Major Traversal
        long startRow = System.nanoTime();
        double rowSum = processor.sumRowMajor();
        long endRow = System.nanoTime();
        double rowTimeMs = (endRow - startRow) / 1e6;
        System.out.println("Row-Major Traversal (Sequential) Time : " + String.format("%.3f", rowTimeMs) + " ms | Sum: " + String.format("%.2f", rowSum));
    }
}