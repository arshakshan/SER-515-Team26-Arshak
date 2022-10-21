public abstract class NodeVisitor {

    Reminder reminder;
    public abstract void visitProduct(ClassProductList product);

    public abstract Reminder visitTrading(Trading trading);

    public abstract void visitFacade(Facade facade);
}
