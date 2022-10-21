import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Facade class takes care of the facade pattern. It calls the
 * classes for bridge pattern, factory pattern, iterator and visitor pattern
 */


public class Facade{
    int UserType;          //hold the usertype, either buyer(0) or seller(1)
    int nProductCategory;   //hold the productType, either Meat(0) or produce(1)
    Product theSelectedProduct; //hold the selected type of product
    ProductMenu theSelectedProductMenu = null; //the new product menu
    ClassProductList theProductList = new ClassProductList(); //holds the list of the entire products list
    Person thePerson ; //holds the type of person
    Trading newTrade; //holds the trading
    Scanner sc = new Scanner(System.in);

    public void facadeStart() throws FileNotFoundException {

        System.out.println("\n********************* Facade Pattern Implemented *********************\n");
        Login u1 = new Login();
        boolean checkLogin = login(u1);
        String username = u1.userName;
        if(!checkLogin) {
            System.out.println("Try Again");
            return;
        }
        else{
            System.out.println("\n********************* Implementing Factory Pattern *********************\n");
            if(UserType==0)
                thePerson = new Buyer();
            else if(UserType==1)
                thePerson = new Seller();
            thePerson.userName = username;
            System.out.println("Enter the type of Menu \n0.Meat\n1. Produce");
            nProductCategory = sc.nextInt();

            if(nProductCategory==0){
                theSelectedProduct = new Product("Meat");
                productOperation(theSelectedProduct);
                AttachProductToUser(theSelectedProductMenu);
                newTrade = new Trading("Meat");
            }else if(nProductCategory==1){
                theSelectedProduct = new Product("Produce");
                productOperation(theSelectedProduct);
                AttachProductToUser(theSelectedProductMenu);
                newTrade = new Trading("Produce");
            }else{
                System.out.println("Wrong Selection");
                System.exit(-1);
            }

            System.out.println("\n********************* Implementing Visitor Pattern *********************\n");
            remind();
            System.out.println("\n********************* Implementing Iterator Pattern *********************\n");


            ProductIterator productIterator = new ProductIterator();
            productIterator.temp = theProductList;

            OfferingIterator offeringIterator = new OfferingIterator(newTrade.list);

            System.out.println("\nThe users Products:");
            while(productIterator.HasNext()){
                System.out.println(productIterator.Next());
            }

            System.out.println("\nSelected Products with user According to Menu");
            SelectProduct(theSelectedProductMenu,UserType);

            System.out.println("\nThe users Trades:");
            while(offeringIterator.HasNext()){
                System.out.println(offeringIterator.Next());
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

    //Reminder visitor function implements the Visitor Pattern and visits all the products of the user
    public void remind(){
        ReminderVisitor remind = new ReminderVisitor();
        this.accept(remind);
    }

    private void accept(ReminderVisitor remind) {
        remind.visitFacade(this);
    }

    public void createUser(UserInfoItem userinfoitem, int userType) {
        userinfoitem.createUser(userType);
    }

    public void createProductList(ProductMenu pM){

        File pl = new File("Design_Pattern/Implementation/txt_file/ProductInfo.txt");
        System.out.println("createProductList");

    }

    //Attaches the user with the productinfo.txt
    public void AttachProductToUser(ProductMenu pM) throws FileNotFoundException {

        File f = new File("Design_Pattern/Implementation/txt_files/UserProduct.txt");
        File f2= new File("Design_Pattern/Implementation/txt_files/ProductInfo.txt");

        Scanner sn = new Scanner(f);
        sn.useDelimiter("\n");
        Scanner sn2 = new Scanner(f2);
        sn2.useDelimiter("\n");
        while(sn.hasNextLine()){
            sn2 = new Scanner(f2);
            String temp[] = sn.nextLine().split(":");
            if(temp[0].equals(thePerson.userName)){
                while(sn2.hasNextLine()){
                    String sn2temp[] = sn2.nextLine().split(":");

                    if(sn2temp[1].equals(temp[1])){
                        if(sn2temp[0].equals(theSelectedProduct.productType)){
//                            System.out.println("erf jl sjl"+sn2temp[1]);
                            this.thePerson.prodList.add(sn2temp[1]);
                        }
                        break;
                    }
                }
                this.theProductList.add(temp[1]);
            }
        }
    }

    //Select product would show the menu products associated with the user according to the MenuType
    public void SelectProduct(ProductMenu pM, int UserType){

        ProductIterator pod = new ProductIterator();
        pod.temp = this.thePerson.prodList;
        while(pod.HasNext()){
            System.out.println(pod.Next());
        }
    }

    //Creates a productMenu
    public void productOperation(Product product){
        System.out.println("\n********************* Implementing the Bridge Pattern *********************\n");
        this.theSelectedProductMenu = thePerson.createProductMenu(product.productType);
    }
}