public abstract class NodeVisitor {

    Reminder reminder;
    public abstract void visitProduct(Product product);

    public abstract void visitTrading(Trading trading);

    public abstract void visitFacade(Facade facade);
}
