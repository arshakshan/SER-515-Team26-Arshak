import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class OfferingList extends ArrayList {

    ArrayList<String> off = new ArrayList<>();

    OfferingList(){

    }
    OfferingList(ArrayList<String> allOffering){
        off = allOffering;
    }

}
