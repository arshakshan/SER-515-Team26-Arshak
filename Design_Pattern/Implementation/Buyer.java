public class Buyer extends Person {


    Buyer(){
        super();
        String userName1 = super.userName;
    }
    ProductMenu buyerProductMenu= null;
    Buyer(ProductMenu theProductMenu) {
        super(theProductMenu);
        buyerProductMenu = theProductMenu;
    }

    @Override
    public void showMenu() {
        // TODO Auto-generated method stub
        System.out.println("Buyer menu items");

    }

    @Override
    public ProductMenu createProductMenu(String pdt) {
        // TODO Auto-generated method stub
        if(pdt.equals("Meat"))
            return new MeatProductMenu();
        else if(pdt.equals("Produce"))
            return new ProduceProductMenu();
        return null;
    }

    public void BuyerTradingMenu(TradingMenu tm){

    }


}
