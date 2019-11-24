
public class BufferProxy {

    private Scheduler scheduler;
    private Buffer activeBuffer;

    public BufferProxy() {
        activeBuffer = new Buffer();
        scheduler = new Scheduler();
        scheduler.start();
    }

    public FutureInteger addElement(int element) {
        AddElementRequest request = new AddElementRequest(activeBuffer, element);
        scheduler.add(request);
        return request.getFutureInteger();
    }

    public FutureInteger removeElement() {
        RemoveElementRequest request = new RemoveElementRequest(activeBuffer);
        scheduler.add(request);
        return request.getFutureInteger();
    }
}
