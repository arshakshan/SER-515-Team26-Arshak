import java.util.Iterator;

public class OfferingIterator implements ListIterator {

    @Override
    public boolean HasNext(Iterator iterator) {
        // TODO Auto-generated method stub
        return iterator.hasNext();
    }

    @Override
    public String Next(Iterator iterator) {
        // TODO Auto-generated method stub
        if(this.HasNext(iterator)){
            return (String)iterator.next();
        }else{
            return null;
        }
    }

    @Override
    public void moveToHead(Iterator iterator) {
        // TODO Auto-generated method stub
        System.out.println("Head Moved....");
    }

    @Override
    public void remove(Iterator iterator) {
        // TODO Auto-generated method stub
        if(this.HasNext(iterator)){
            iterator.next();
        }
    }
    
}
