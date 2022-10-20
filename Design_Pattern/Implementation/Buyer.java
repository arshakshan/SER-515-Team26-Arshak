public class Buyer extends Person {


    Buyer(){
        super();
        String userName1 = super.userName;
    }

    Buyer(ProductMenu theProductMenu) {
        super(theProductMenu);
    }

    @Override
    public void showMenu() {
        // TODO Auto-generated method stub
        System.out.println("Buyer menu items");

    }

    @Override
    public ProductMenu createProductMenu() {
        // TODO Auto-generated method stub

        return null;
    }

    public void BuyerTradingMenu(TradingMenu tm){

    }


}
