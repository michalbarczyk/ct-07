public class RemoveElementRequest extends AbstractMethodRequest {

    RemoveElementRequest(Buffer activeBuffer) {
        super(activeBuffer);
    }

    public boolean guard() {
        return activeBuffer.isEmpty();
    }

    public void execute() {
        futureInteger.setValue(activeBuffer.removeElement());
    }
}
