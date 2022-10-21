import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProduceProductMenu implements ProductMenu {

    //The ProduceProductMenu would be created
    ProduceProductMenu(){
        System.out.println("\n********* Produce Product menu Created. Showing all produce products *********\n");
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

        sc.useDelimiter("\n");
        System.out.println("\nMenu Items for Produce: ");
        int counter=1;
        while (sc.hasNextLine()) {
            String[] temp = sc.nextLine().split(":");
            if(temp[0].toString().equals("Produce")){
                System.out.println(counter + ". "+ temp[1].toString());
                counter++;
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
        System.out.println("Show View Button");

    }

    @Override
    public void showRadioButton() {
        // TODO Auto-generated method stub
        System.out.println("Show Radio Button");
    }

    @Override
    public void showLabels() {
        // TODO Auto-generated method stub
        System.out.println("Show Labels Button");

    }

    @Override
    public void showComboxes() {
        // TODO Auto-generated method stub
        System.out.println("Show Comboxes Button\n");
    }

    @Override
    public void selectProduct(int UserType) {

    }

}
