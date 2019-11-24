import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Scheduler extends Thread {

    private Queue<AbstractMethodRequest> requestQueue;

    public Scheduler() {
        requestQueue = new ConcurrentLinkedQueue<AbstractMethodRequest>();
    }

    public void add(AbstractMethodRequest request) {
        requestQueue.add(request);
    }

    public void run() {
        while (true) {
            AbstractMethodRequest request = requestQueue.poll();
            if (request != null) {
                if (request.guard()) {
                    requestQueue.add(request); // execution in the future
                } else {
                    request.execute();
                }
            }
            //try {Thread.sleep(1);} catch (InterruptedException ex) {}
        }
    }
}
