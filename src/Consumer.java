public class Consumer extends Thread {
    private BufferProxy bufferProxy;
    public Consumer(BufferProxy bufferProxy) {
        this.bufferProxy = bufferProxy;
    }
    public void run() {
        for (int i = 0; i < 30; i++) {
            FutureInteger x = bufferProxy.removeElement();
            while (!x.available());
            System.out.println("consumer " + x.getValue());
            //try {Thread.sleep(1);} catch (InterruptedException ex) {}
        }
    }
}