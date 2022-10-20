import java.util.ArrayList;
import java.util.Iterator;

public class ClassProductList {

    ArrayList<String> pdt = new ArrayList<>();
    Product n= null;

    ClassProductList(){

    }

    public ClassProductList(ArrayList<String> allProducts) {
        pdt = allProducts;
    }

    public Iterator createIterator() {
        return this.pdt.iterator();
    }

    public Reminder accept(ReminderVisitor remind) {
        System.out.println("Product List Reminder");
        return remind.visitProduct(this.n);
    }

//    public ReminderVisitor accept(NodeVisitor visitor){
//        System.out.println("Product List Reminder");
//        return visitor.visitProduct(n);
//    }
}
