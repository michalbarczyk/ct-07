public class Producer extends Thread {
    private BufferProxy bufferProxy;
    public Producer(BufferProxy bufferProxy) {
        this.bufferProxy = bufferProxy;
    }
    public void run() {
        for (int i = 0; i < 30; i++) {
            FutureInteger x = bufferProxy.addElement(i);
            while (!x.available());
            System.out.println("producer " + x.getValue());
            //try {Thread.sleep(1);} catch (InterruptedException ex) {}
        }
    }
}
