import java.util.Iterator;

public interface ListIterator {
    
    public abstract boolean hasNext(Iterator iterator);

    public abstract Object next(Iterator iterator);

    public abstract void moveToHead(Iterator iterator);

    public abstract void remove(Iterator iterator);
}
