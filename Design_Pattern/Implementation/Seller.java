public class Seller extends Person {

    Seller(){
        super();
    }
    Seller(ProductMenu theProductMenu) {
        super(theProductMenu);
    }

    @Override
    public void showMenu() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ProductMenu createProductMenu(String pdtType) {
        // TODO Auto-generated method stub
        return null;
    }

    public void SellerTradingMenu(TradingMenu tm){

    }


}
