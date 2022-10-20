import java.util.Iterator;

public interface ListIterator {
    
    public abstract boolean HasNext(Iterator iterator);

    public abstract String Next(Iterator iterator);

    public abstract void moveToHead(Iterator iterator);

    public abstract void remove(Iterator iterator);
}
