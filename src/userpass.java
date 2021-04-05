import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

public class userpass {
	static boolean userpass(String exist, String user, String pass) throws IOException {
		List<String[]> userpass = passdoc("passdoc.csv");
		int i = 0;

		while (i < userpass.size())
			if (exist.toLowerCase().contains("yes")) {
				userpass = passdoc("passdoc.csv");
				
				
				int username;
				int password;
				String[] temp = new String[2];
				temp[0] = user;
				temp[1] = pass;

				if ((Arrays.deepToString(temp).equals(Arrays.deepToString(userpass.get(i))))) {

					System.out.println("you are a user");
					return true;
				} else {
					System.out.println("not a user");
					return false;
				}
			} else if (exist.toLowerCase().contains("no")) {
				String[] temp = new String[2];
				temp[0] = user;
				temp[1] = pass;
				userpass.add(temp);
				CSVWRITER.CSVWRITER("passdoc.csv", userpass);
				System.out.println("made a new user for testing check passdoc.csv");
				i++;
				return false;
			} else {
				System.out.println("error");
				System.exit(1);
			}
		return false;

	}

	public static List<String[]> passdoc(String filename) throws IOException {
		// open file input stream
		/**
		 * This method is the method that reads in the data from a csv file to an array
		 * list Hard coded file path at the moment that will change
		 * 
		 * @param takes in the file path
		 * @return puts data into array list no return
		 * @author Hunter Holton
		 */
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;

		List<String[]> csvData = new ArrayList<String[]>();

		while ((line = reader.readLine()) != null) {
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			String line2[] = new String[2];
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					line2[0] = data.toString();
				else if (index == 1)
					line2[1] = data.toString();

				else
					System.out.println("invalid data::" + data);

				index++;

			}
			index = 0;
			csvData.add(line2);

		}

		/* System.out.println(Arrays.deepToString(csvData.toArray())); */
		reader.close();
		return csvData;

	}

}
