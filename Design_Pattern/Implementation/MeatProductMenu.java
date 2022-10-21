import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MeatProductMenu implements ProductMenu{

    ClassProductList meatProductList = null;

    //MeatProductMenu creates the meat product menu for the person
    MeatProductMenu(){
        System.out.println("\n********* Meat Product menu Created. Showing all meat products *********\n");
        showMenu();
        System.out.println("");
        showAddButton();
        showViewButton();
        showRadioButton();
        showLabels();
        showComboxes();
    }
    @Override
    public void showMenu() {
        // TODO Auto-generated method stub
        File file = new File("Design_Pattern/Implementation/txt_files/ProductInfo.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int counter =1;
        sc.useDelimiter("\n");
        System.out.println("\nMenu Items for Meat: ");
        while (sc.hasNextLine()) {
            String[] temp = sc.nextLine().split(":");
            if(temp[0].toString().equals("Meat")){
                System.out.println(counter + ". "+ temp[1].toString());
                counter++;
            }
        }

    }

    @Override
    public void showAddButton() {
        // TODO Auto-generated method stub
        System.out.println("Showing Add Button");
    }

    @Override
    public void showViewButton() {
        // TODO Auto-generated method stub
        System.out.println("Showing view button");
    }

    @Override
    public void showRadioButton() {
        // TODO Auto-generated method stub
        System.out.println("Showing Radio Button");
    }

    @Override
    public void showLabels() {
        // TODO Auto-generated method stub
        System.out.println("Showing labels");
    }

    @Override
    public void showComboxes() {
        // TODO Auto-generated method stub
        System.out.println("Showing Comboxes");
    }

    @Override
    public void selectProduct(int UserType) {

    }

}
