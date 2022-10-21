import java.util.ArrayList;
import java.util.Iterator;

public class ClassProductList extends ArrayList{

    ArrayList<String> pdt;
    Trading t = new Trading("Product");
    Product n= null;

    ClassProductList(){

    }

    public ClassProductList(ArrayList<String> allProducts) {

        pdt = allProducts;
    }


    public void accept(NodeVisitor remind) {

        int pos =0;
        while(pos < this.size()) {
            System.out.println("\nProduct Reminder for "+this.get(pos));
            System.out.println("Visiting Product "+this.get(pos));
            remind.visitProduct(this);
            pos++;
        }
    }


}
