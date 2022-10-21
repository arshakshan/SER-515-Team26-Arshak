public class Trading {

    OfferingList list = new OfferingList();
    Product pt;

    Trading(String trade){
        list.add(trade);
    }
    Reminder reminder;
    public Reminder accept(NodeVisitor visitor){
        System.out.println("Trading Reminder");
        return visitor.visitTrading(this);
    }



}
