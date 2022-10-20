import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MeatProductMenu implements ProductMenu{

    ClassProductList meatProductList = null;
    MeatProductMenu(){

    }
    @Override
    public void showMenu() {
        // TODO Auto-generated method stub
        File file = new File("txt_files/ProductInfo.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int counter =1;
        sc.useDelimiter("\n");
        System.out.println("\nMenu Items for Produce: ");
        while (sc.hasNextLine()) {
            String[] temp = sc.nextLine().split(":");
            if(temp[0].toString().equals("Meat")){
                System.out.println(counter + ". "+ temp[1].toString());
            }
        }

    }

    @Override
    public void showAddButton() {
        // TODO Auto-generated method stub
        System.out.println("Show Add Button");
    }

    @Override
    public void showViewButton() {
        // TODO Auto-generated method stub
        System.out.println("Show view button");
    }

    @Override
    public void showRadioButton() {
        // TODO Auto-generated method stub
        System.out.println("SHow Radio Button");
    }

    @Override
    public void showLabels() {
        // TODO Auto-generated method stub
        System.out.println("Show labels");
    }

    @Override
    public void showComboxes() {
        // TODO Auto-generated method stub
        System.out.println("Show Comboxes");
    }

    @Override
    public void selectProduct(int UserType) {

    }

}
