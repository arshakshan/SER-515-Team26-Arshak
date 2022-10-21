import java.util.Iterator;

public interface ListIterator {
    
    public abstract boolean HasNext();

    public abstract Object Next();

    public abstract void moveToHead();

    public abstract void remove();
}
