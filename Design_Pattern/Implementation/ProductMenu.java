public interface ProductMenu {

    public static ClassProductList mProductList = null;
    public abstract void showMenu();
    public abstract void showAddButton();
    public abstract void showViewButton();
    public abstract void showRadioButton();
    public abstract void showLabels();
    public abstract void showComboxes();

    public abstract void selectProduct(int UserType);

//    public void createProductList(){
//
//    }
//
//    public void AttachProductToUser(){
//
//    }
//
//    public void productOperation(){
//
//    }
}
