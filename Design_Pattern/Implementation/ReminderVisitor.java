import java.util.Iterator;

public class ReminderVisitor extends NodeVisitor{

    Reminder m_Reminder;

    //visits the Product Class
    @Override
    public void visitProduct(ClassProductList pl) {
        // TODO Auto-generated method stub
        ProductIterator itr = new ProductIterator();
        itr.temp = pl;
        int position=0;
        pl.t.accept(this);
    }

    //visits the Trading class
    @Override
    public Reminder visitTrading(Trading trading) {
        // TODO Auto-generated method stub
        int i=0;
        while(i<trading.list.size()){
            System.out.println("Visiting Trading "+ trading.list.get(i) +"\n");
            i++;
        }

        return null;
    }

    //visits the Facade class
    @Override
    public void visitFacade(Facade facade) {
        // TODO Auto-generated method stub
        System.out.println("Visiting Facade");
        ProductIterator it = new ProductIterator();
        it.temp = facade.theProductList;
        System.out.println("");
        while(it.HasNext()){
            System.out.println(it.Next());
        }
        facade.theProductList.accept(this);
    }
    
}
