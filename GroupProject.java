import java.io.*;
import java.util.*;
import java.util.List;
import java.util.*;
import javax.swing.*;
import java.awt.*;

class GroupProject {
	private static boolean userpass(String exist, String user, String pass) throws IOException {
		List<String[]> userpass = passdoc("passdoc.csv");
		if (exist.toLowerCase().contains("yes")) {
			userpass = passdoc("passdoc.csv");
			System.out.println(Arrays.deepToString(userpass.toArray()));
			int username;
			int password ;
			username = userpass.indexOf(user);
			password = userpass.indexOf(pass);
			System.out.println(username);
			System.out.println(password);
			
			if ((username == password) == true) {
				System.out.println("yep");
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
			CSVWRITER("passdoc.csv", userpass);
		}else {
			System.out.println("error");
			System.exit(1);
		}
		return false;

	}

	public static void maniplation(List<String[]> csvData) throws IOException {
		String line = null;
		Scanner scanner = null;
		int index = 0;
		/* List<String[]> csvData = new ArrayList<String[]>(); */
		System.out.println("What would you like to do to your data?: ");
		Scanner sysin = new Scanner(System.in);
		String userin = sysin.nextLine();
		if (userin.equals("add")) {
			/**
			 * This method is the main method for manipulation of data in the array list The
			 * first part is the add part of manipulation
			 * 
			 * @param user input for the data that they want to enter it must be everything
			 *             (product_id,quantity,wholesale_cost,sale_price,supplier_id)
			 * @return doesn't return anything adds to csv array list
			 * @author Hunter Holton
			 */
			System.out.println("please enter the data you would like to add seperated by commas");
			BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
			line = userinput.readLine();
			scanner = new Scanner(line);
			String line2[] = new String[5];
			scanner.useDelimiter(",");
			if (line != null) {
				while ((scanner.hasNext())) {

					String data = scanner.next();
					if (index == 0)
						line2[0] = data.toString();
					else if (index == 1)
						line2[1] = data.toString();
					else if (index == 2)
						line2[2] = data.toString();
					else if (index == 3)
						line2[3] = data.toString();
					else if (index == 4) {
						line2[4] = data.toString();
					} else
						System.out.println("invalid data::" + data);
					index++;
				}
				csvData.add(line2);
			} else {
				scanner.close();
				System.exit(0);
			}
		} else if (userin.equals("Search")) {
			System.out.println("What is the ID you are looking for?");
			Scanner idCheck = new Scanner(System.in);
			String id = idCheck.next();
			for (int i = 0; i < csvData.size(); i++) {

				String line2[] = new String[5];
				line2 = csvData.get(i);
				if (id.equals(line2[0])) {
					System.out.println("Product ID: " + line2[0] + ", " + "In Stock: " + line2[1] + ", "
							+ "Wholesale Cost: " + "$" + line2[2] + ", " + "Sale Price: " + "$" + line2[3] + ", "
							+ "Supplier ID: " + line2[4]);
				}
			}
		}

		else if (userin.equals("Update")) {
			System.out.println("What is the ID of the item you would like to update?");
			Scanner idCheck = new Scanner(System.in);
			String id = idCheck.next();
			for (int i = 0; i < csvData.size(); i++) {

				String line2[] = new String[6];
				line2 = csvData.get(i);
				if (id.equals(line2[0])) {
					System.out.println("What would you like to update?\n Enter ID to update the items ID \n"
							+ "Enter Stock to update how many units are in stock \n Enter Wholesale to update the items"
							+ "wholesale cost \n Enter Sale to update the items sales price \n enter Supplier to update"
							+ "the sellers ID");
					Scanner tempScanner = new Scanner(System.in);
					String tempUpdate = tempScanner.next();
					if (tempUpdate.equals("ID")) {
						System.out.println("What is the new ID?");
						Scanner tempScan = new Scanner(System.in);
						String tempData = tempScan.next();
						line2[0] = "";
						line2[0] = tempData;
					} else if (tempUpdate.equals("Stock")) {
						System.out.println("What is the new Stock?");
						Scanner tempScan = new Scanner(System.in);
						String tempData = tempScan.next();
						line2[1] = "";
						line2[1] = tempData;
					} else if (tempUpdate.equals("Wholesale")) {
						System.out.println("What is the new Wholesale price?");
						Scanner tempScan = new Scanner(System.in);
						String tempData = tempScan.next();
						line2[2] = "";
						line2[2] = tempData;
					} else if (tempUpdate.equals("Sale")) {
						System.out.println("What is the new sale price?");
						Scanner tempScan = new Scanner(System.in);
						String tempData = tempScan.next();
						line2[3] = "";
						line2[3] = tempData;
					} else if (tempUpdate.equals("Supplier")) {
						System.out.println("What is the new supplier ID?");
						Scanner tempScan = new Scanner(System.in);
						String tempData = tempScan.next();
						line2[4] = "";
						line2[4] = tempData;
					}
				}
			}
		} else if (userin.equalsIgnoreCase("Delete")) {
			System.out.println("What row would you like to delete");
			Scanner Rowline = new Scanner(System.in);
			String Row = Rowline.next();
			for (int i = 0; i < csvData.size(); i++) {

				String line2[] = new String[5];
				line2 = csvData.get(i);
				if (Row.equals(line2[0])) {

					csvData.remove(i);

					System.out.println(line2[0] + "" + "Has been deleted");
				}
			}
		} // System.out.println(Arrays.deepToString(csvData.toArray()));
	}

	public static List<String[]> reader() throws IOException {
		// open file input stream
		/**
		 * This method is the method that reads in the data from a csv file to an array
		 * list Hard coded file path at the moment that will change
		 * 
		 * @param takes in the file path
		 * @return puts data into array list no return
		 * @author Hunter Holton
		 */
		BufferedReader reader = new BufferedReader(new FileReader("inventory_team6.csv"));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;

		List<String[]> csvData = new ArrayList<String[]>();

		while ((line = reader.readLine()) != null) {
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			String line2[] = new String[5];
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					line2[0] = data.toString();
				else if (index == 1)
					line2[1] = data.toString();
				else if (index == 2)
					line2[2] = data.toString();
				else if (index == 3)
					line2[3] = data.toString();
				else if (index == 4)
					line2[4] = data.toString();

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

	public static void CSVWRITER(String namecsv, List<String[]> csvData) throws IOException {
		// Opens file writer
		FileWriter writer = new FileWriter(namecsv);
		int i = 0;
		int j = 0;
		// uses size of arraylist to determine the amount of times that while loop will
		// run to write to file
		while (i < csvData.size()) {
			j = 0;

			while (j < csvData.get(i).length) {
				String[] temp = csvData.get(i);
				if (j == 4) {
					writer.append(temp[j] + "\n");
					j++;

				} else {

					writer.append(temp[j] + ",");
					j++;
				}

			}
			i++;
		}
		writer.close();

	}

	public static void main(String[] args) throws IOException {
		boolean cont = true;
		while (cont) {
			Scanner sc = new Scanner(System.in);
			System.out.println("do you have an existing account? (yes,no)");
			String exist = sc.next();
			System.out.println("USERNAME: ");
			String username = sc.next();
			System.out.println(username);
			System.out.println("PASSWORD: ");
			String password = sc.next();
			System.out.println(password);
			if (userpass(exist, username, password)) {

				JFrame frame = new JFrame();
				frame.setSize(500, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JPanel pane = new JPanel();

				JButton add = new JButton("Add Data");
				add.setBounds(30, 40, 100, 20);
				frame.add(add);

				JTextField itemID = new JTextField("Enter ID");
				itemID.setBounds(30, 60, 100, 20);
				frame.add(itemID);
				JTextField quantity = new JTextField("Enter Quantity");
				quantity.setBounds(30, 80, 100, 20);
				frame.add(quantity);
				JTextField wholesaleCost = new JTextField("Enter Wholesale Cost");
				wholesaleCost.setBounds(30, 100, 100, 20);
				frame.add(wholesaleCost);
				JTextField salePrice = new JTextField("Enter Sale Price");
				salePrice.setBounds(30, 120, 100, 20);
				frame.add(salePrice);
				JTextField suplierID = new JTextField("Enter Supplier ID");
				suplierID.setBounds(30, 140, 100, 20);
				frame.add(suplierID);

				JButton search = new JButton("Search");
				search.setBounds(30, 180, 100, 20);
				frame.add(search);
				JTextField searchBar = new JTextField("Enter ID");
				searchBar.setBounds(30, 200, 100, 20);
				frame.add(searchBar);
				JTextArea results = new JTextArea("Results");
				results.setBounds(30, 220, 100, 20);
				frame.add(results);

				JButton delete = new JButton("Delete");
				delete.setBounds(30, 260, 100, 20);
				frame.add(delete);
				JTextField deleteSearch = new JTextField("Enter Sale Price");
				deleteSearch.setBounds(30, 280, 100, 20);
				frame.add(deleteSearch);

				JButton update = new JButton("Update");
				update.setBounds(30, 320, 100, 20);
				frame.add(update);
				JTextField updateItemID = new JTextField("Enter ID");
				updateItemID.setBounds(30, 340, 100, 20);
				frame.add(updateItemID);
				JTextField updateQuantity = new JTextField("Enter Quantity");
				updateQuantity.setBounds(30, 360, 100, 20);
				frame.add(updateQuantity);
				JTextField updateWholesaleCost = new JTextField("Enter Wholesale Cost");
				updateWholesaleCost.setBounds(30, 380, 100, 20);
				frame.add(updateWholesaleCost);
				JTextField updateSalePrice = new JTextField("Enter Sale Price");
				updateSalePrice.setBounds(30, 400, 100, 20);
				frame.add(updateSalePrice);
				JTextField updateSuplierID = new JTextField("Enter Supplier ID");
				updateSuplierID.setBounds(30, 420, 100, 20);
				frame.add(updateSuplierID);
				frame.add(pane);
				frame.setVisible(true);
			} else {
				System.out.println("something went wrong or you just created an account do you wish to try again?");
				String temp = sc.next();
				if (temp.toLowerCase().equals("yes")) {
					cont = true;
				} else {
					cont = false;
				}
			}

		}

	}
}
