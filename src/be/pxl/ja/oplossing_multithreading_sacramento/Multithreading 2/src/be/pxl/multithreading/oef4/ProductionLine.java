import java.util.ArrayDeque;
import java.util.Deque;

public class ProductionLine {
    private Deque<Package> packages = new ArrayDeque<>();

    public synchronized void addPackage(Package pakje) {
        packages.addLast(pakje);
    }

    public synchronized Package getPackage() {
        if (packages.size() > 0) {
            return packages.poll();
        }
        return null;
    }
}
