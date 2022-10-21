import java.io.FileNotFoundException;


// Run the main function. This would access the facade and proceed with the PTBS
public class Main {
    public static void main(String[] args) {
        System.out.println("\nWorking Directory = " + System.getProperty("user.dir"));
        Facade facade = new Facade();
        try {
            facade.facadeStart();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
