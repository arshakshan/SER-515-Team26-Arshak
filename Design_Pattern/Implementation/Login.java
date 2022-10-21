import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {

    int UserType;
    String userName;
    public int login() throws FileNotFoundException {
        String username, password, user;
        File userInfo ;
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the user Type: Buyer or Seller");
        user = scan.next();

        if((user.equals("buyer")) || (user.equals("Buyer"))){
            UserType =0;
        }else{
            UserType =1;
        }

//        System.out.println(UserType);
        System.out.println("enter the username: ");
        username = scan.next();
        userName = username;
        System.out.println("enter the password");
        password = scan.next();

        if(UserType==0){
            userInfo = new File("Design_Pattern/Implementation/txt_files/BuyerInfo.txt");
        }else{
            userInfo = new File("Design_Pattern/Implementation/txt_files/SellerInfo.txt");
        }

        Scanner fileScan = new Scanner(userInfo);
        fileScan.useDelimiter("\n");
        while(fileScan.hasNextLine()){
            String[] temp = fileScan.nextLine().split(":");

            if((temp[0].toString().equals(username)) && (temp[1].toString().equals(password))) {
                System.out.println("LoggedIn. Welcome "+temp[0].toString());
                return UserType;
            }
        }
//        System.out.println("Try Again");
        return -1;
    }

}
