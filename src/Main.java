import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferProxy bufferProxy = new BufferProxy();
        List<Thread> workers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            workers.add(new Consumer(bufferProxy));
            workers.add(new Producer(bufferProxy));
        }
        for (Thread worker : workers)
            worker.start();
        try {
            for (Thread worker : workers)
                worker.join();
        } catch (InterruptedException ex) {}
    }
}
