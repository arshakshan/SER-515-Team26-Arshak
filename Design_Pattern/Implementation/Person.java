
public abstract class Person {
    ProductMenu theProductMenu;
    ClassProductList prodList = new ClassProductList();
    String userName;
    public abstract ProductMenu createProductMenu(String pdt);
    Person(){

    }

    Person(ProductMenu theProductMenu){

        this.theProductMenu = theProductMenu;
    }
    public abstract void showMenu();
    
    public void showAddButton(){

        theProductMenu.showAddButton();
    }
    public void showViewButton(){

        theProductMenu.showViewButton();
    }
    public void showRadioButton(){

        theProductMenu.showRadioButton();
    }
    public void showLablels(){

        theProductMenu.showLabels();

    }


}
