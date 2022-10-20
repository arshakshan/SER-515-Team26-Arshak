import java.util.ArrayList;
import java.util.Iterator;

public class OfferingList {

    ArrayList<String> off = new ArrayList<>();

    OfferingList(){

    }

    public Iterator createIterator() {
        return this.off.iterator();
    }
}
