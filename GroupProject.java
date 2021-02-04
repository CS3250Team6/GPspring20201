import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class GroupProject {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		Scanner sc = new Scanner(new File("inventory_team6.csv"));   
		sc.useDelimiter(",");

		while(sc.hasNext()) {
			System.out.println(sc.next());
		}
	}
}