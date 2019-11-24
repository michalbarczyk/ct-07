import java.util.concurrent.atomic.AtomicBoolean;

public class FutureInteger {

    private int integer;
    private AtomicBoolean available;

    public FutureInteger() {
        available = new AtomicBoolean(false);
    }

    public int getValue() {
        return integer;
    }

    public void setValue(int integerValue) {
        this.integer = integerValue;
        this.available.set(true);
    }

    public boolean available() {
        return available.get();
    }
}
