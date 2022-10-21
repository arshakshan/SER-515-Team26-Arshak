import java.util.Iterator;
import java.util.List;

public class ProductIterator implements ListIterator {

    ClassProductList temp;
    int pos = 0;
//    ProductIterator(ClassProductList cl){
//        temp=cl;
//        pos=0;
//    }
    @Override
    public boolean HasNext() {
        // TODO Auto-generated method stub
        if(pos < temp.size()){
//            System.out.println("pos value: "+pos+" isnide hasNext, temp size: "+temp.size());
            return true;
        }else{
            return false;
        }

    }


    @Override
    public Object Next() {
        // TODO Auto-generated method stub
        if(this.HasNext())
        {
            Object content = temp.get(pos);
            pos = pos+1;
//            System.out.println("pos value: "+pos+" isnide hasNext, temp size: "+temp.size());
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
