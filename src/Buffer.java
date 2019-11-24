import java.util.LinkedList;
import java.util.List;

public class Buffer {
    private int currSize;
    private static final int MAX_BUFFER_SIZE = 20;

    private List<Integer> content;

    public Buffer() {
        content = new LinkedList<>();
        currSize = 0;
    }

    public boolean isFull() {
        return currSize == MAX_BUFFER_SIZE;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public int addElement(int element) {
        currSize++;
        content.add(element);
        return element;
    }

    public int removeElement() {
        currSize--;
        return content.remove(0);
    }
}
