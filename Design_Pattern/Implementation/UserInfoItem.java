import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInfoItem {
    int userType;
	public void createUser(int userType){

		File file = null;
		String username, pass;
		Scanner sc = new Scanner(System.in);

		if(userType==0)
			file = new File("txt_files/BuyerInfo.txt");
		else if(userType==1)
			file = new File("txt_files/SellerInfo.txt");

		System.out.println("Enter a username: ");
		username = sc.next();

		System.out.println("Enter a password: ");
		pass = sc.next();

		String data = username+":"+pass;

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file.getName(),true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			bw.write(data);
			bw.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		System.out.println(" User Created ....");
	}
}
