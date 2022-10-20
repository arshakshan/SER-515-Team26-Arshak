import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

/*
 * Facade class takes care of the facade pattern. It calls the
 * classes for bridge pattern, factory pattern, iterator and visitor pattern
 */


public class Facade{
    int UserType;
    int nProductCategory;
    Product theSelectedProduct;
    ProductMenu theSelectedProductMenu = null;
    ClassProductList theProductList= null;
    Person thePerson ;
    Scanner sc = new Scanner(System.in);

    public void facadeStart() throws FileNotFoundException {

        System.out.println("Facade Pattern Implemented");
        Login u1 = new Login();
        boolean checkLogin = login(u1);
        String username = u1.userName;
        if(!checkLogin) {
            System.out.println("Try Again");
            return;
        }
        else{
            if(UserType==0)
                thePerson = new Buyer();
            else if(UserType==1)
                thePerson = new Seller();
            thePerson.userName = username;
            System.out.println("Enter the type of Menu 0. Meat 1. Produce");
            int choice = sc.nextInt();

            if(choice==0){
                theSelectedProduct = new Product("Meat");
                theSelectedProductMenu = new MeatProductMenu();
                AttachProductToUser(theSelectedProductMenu);
                SelectProduct(theSelectedProductMenu,UserType);
            }else if(choice==1){
                theSelectedProduct = new Product("Produce");
                theSelectedProductMenu = new ProduceProductMenu();
                AttachProductToUser(theSelectedProductMenu);
                SelectProduct(theSelectedProductMenu,UserType);
            }else{
                System.out.println("Wrong Selection");
                System.exit(-1);
            }

            System.out.println("Implementing Visitor Pattern");
            remind();
            System.out.println("Implementing Iterator Pattern");

//            theProductList = new ClassProductList();
            Iterator iterate = (Iterator) this.theProductList.createIterator();
            ProductIterator productIterator = new ProductIterator();

            OfferingList offList = new OfferingList();
            Iterator iterator2 = (Iterator) offList.createIterator();
            OfferingIterator offeringIterator = new OfferingIterator();

            while(productIterator.HasNext(iterate)){
                System.out.println(productIterator.Next(iterate));
                System.out.println(offeringIterator.Next(iterator2));
            }
        }

    }
    public boolean login(Login object) throws FileNotFoundException {

        int UserType = object.login();
        if(UserType==0 || UserType==1)
            return true;
        else
            return false;
    }

    public void addTrading(TradingMenu tM){
        tM.addTrade();
    }

    public void viewTrading(TradingMenu tM){
        tM.viewTrade();
    }

    public void decideBidding(OfferingMenu om){
        om.decideBidding();
    }

    public void discussBidding(OfferingMenu om){
        om.discussBidding();
    }

    public void submitBidding(OfferingMenu om){
        om.submitBidding();
    }

    public void remind(){
        ReminderVisitor remind = new ReminderVisitor();
        ClassProductList productList = new ClassProductList();
        productList.accept(remind);
    }

    public void createUser(UserInfoItem userinfoitem, int userType) {
        userinfoitem.createUser(userType);
    }

    public void createProductList(ProductMenu pM){

        File pl = new File("txt_file/ProductInfo.txt");

    }

    public void AttachProductToUser(ProductMenu pM) throws FileNotFoundException {

        ArrayList<String> reqproducts = new ArrayList<>();
        ArrayList<String> allProducts = new ArrayList<>();
        File f = new File("txt_files/UserProduct.txt");
        File f2= new File("txt/ProductInfo.txt");

        Scanner sn = new Scanner(f);
        sn.useDelimiter("\n");
        Scanner sn2 = null;
        sn2.useDelimiter("\n");
        while(sn.hasNextLine()){
            sn2 = new Scanner(f2);
            String temp[] = sn.nextLine().split(":");
            if(temp[0].equals(thePerson.userName)){
                while(sn2.hasNextLine()){
                    String sn2temp[] = sn2.nextLine().split(":");
                    if(sn2temp[1].equals(temp[1])){
                        if(sn2temp[0]==theSelectedProduct.productType){
                            reqproducts.add(sn2temp[1]);
                        }
                        break;
                    }
                }
                allProducts.add(temp[1]);
            }
        }
        this.theProductList = new ClassProductList(allProducts);

        this.thePerson.prodList = new ClassProductList(reqproducts);
    }

    public void SelectProduct(ProductMenu pM, int UserType){
        for (String str : this.thePerson.prodList.pdt)
        {
            System.out.println(str);
        }
        pM.selectProduct(UserType);
    }

    public void productOperation(ProductMenu pM){
        ProductMenu temp = thePerson.createProductMenu();
    }
}