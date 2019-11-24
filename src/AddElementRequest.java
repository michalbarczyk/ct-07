import java.util.concurrent.Future;

public class AddElementRequest extends AbstractMethodRequest {

    private int elementToBeAdded;

    public AddElementRequest(Buffer activeBuffer, int elementToBeAdded) {
        super(activeBuffer);
        this.elementToBeAdded = elementToBeAdded;
    }

    public boolean guard() {
        return activeBuffer.isFull();
    }

    public void execute() {
        futureInteger.setValue(activeBuffer.addElement(elementToBeAdded));
    }
}
