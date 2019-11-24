public abstract class AbstractMethodRequest {
    protected FutureInteger futureInteger;
    protected Buffer activeBuffer;

    public AbstractMethodRequest(Buffer activeBuffer) {
        this.activeBuffer = activeBuffer;
        futureInteger = new FutureInteger();
    }

    public abstract boolean guard();

    public abstract void execute();

    public FutureInteger getFutureInteger() {
        return futureInteger;
    }
}


