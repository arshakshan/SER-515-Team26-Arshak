import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Iterator;

/*
 * Facade class takes care of the facade pattern. It calls the
 * classes for bridge pattern, factory pattern, iterator and visitor pattern
 */


public class Facade{
    int UserType;
    int nProductCategory;
    Product theSelectedProduct = new Product();
    ClassProductList theProductList= new ClassProductList();
    Person thePerson ;

    public boolean login(Login object) throws FileNotFoundException {

        int UserType = object.login();
        if(UserType==1)
            thePerson = new Buyer();
        else
            return false;
    }

    public void addTrading(TradingMenu tM){

    }

    public void viewTrading(TradingMenu tM){

    }

    public void decideBidding(){

    }

    public void discussBidding(){

    }

    public void submitBidding(){

    }

    public void remind(){

    }

    public void createUser(UserInfoItem userinfoitem){

    }

    public void createProductList(ProductMenu pM){

    }

    public void AttachProductToUser(ProductMenu pM){
        
    }

    public Product SelectProduct(ProductMenu pM, int UserType){

        return null;
    }

    public void productOperation(ProductMenu pM){

    }
}