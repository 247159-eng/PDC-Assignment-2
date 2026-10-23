import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapWorker implements Runnable {
    private ConcurrentMap<String, CatalogItem> catalog;
    private int iterations;

    public ConcurrentHashMapWorker(ConcurrentMap<String, CatalogItem> catalog, int iterations) {
        this.catalog = catalog;
        this.iterations = iterations;
    }

    @Override
    public void run() {}
}