import java.util.Iterator;

public class OfferingIterator implements ListIterator {

    OfferingList temp = new OfferingList();
    int p;

    OfferingIterator(OfferingList offeringList){
        temp = offeringList;
        p = 0;
    }
    @Override
    public boolean HasNext() {
        // TODO Auto-generated method stub
        if(p < temp.size()){
            return true;
        }
        return false;
    }

    @Override
    public Object Next() {
        // TODO Auto-generated method stub
        if(HasNext())
        {
            Object content = temp.get(p);
            p++;
            return content;
        }
        return null;
    }

    @Override
    public void moveToHead() {
        // TODO Auto-generated method stub
        System.out.println("Head Moved....");
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        if (this.HasNext()) {
            System.out.println("Remove Element");
        }
    }
    
}
