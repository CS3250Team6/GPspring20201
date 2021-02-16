import java.io.*
import java.util.*;

class GroupProject {
	private static void userpass(String user, String pass) {
		if (user.equals("user") && pass.equals("pass")) {

			System.out.println("you are an authorized user");
		}

		else {
			System.exit(0);
		}
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
			 * This method is the main method for manipulation of data in the array list 
			 * The first part is the add part of manipulation 
			 * @param user input for the data that they want to enter it must be everything (product_id,quantity,wholesale_cost,sale_price,supplier_id) 
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
		}
		        else if (userin.equals("Search")) {
            System.out.println("What is the ID you are looking for?");
            Scanner idCheck = new Scanner(System.in);
            String id = idCheck.next();
            for (int i = 0; i < csvData.size(); i++) {

                String line2[] = new String[5];
                line2 = csvData.get(i);
                if (id.equals(line2[0])) {
                    System.out.println("Product ID: " + line2[0]+ ", " + "In Stock: " + line2[1] + ", " +
                     "Wholesale Cost: " + "$" + line2[2] + ", " + "Sale Price: " + "$" + line2[3] + ", " +
                     "Supplier ID: " + line2[4]);
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
                    System.out.println("What would you like to update?\n Enter ID to update the items ID \n" +
                            "Enter Stock to update how many units are in stock \n Enter Wholesale to update the items" +
                            "wholesale cost \n Enter Sale to update the items sales price \n enter Supplier to update" +
                            "the sellers ID");
                    Scanner tempScanner = new Scanner(System.in);
                    String tempUpdate = tempScanner.next();
                    if (tempUpdate.equals("ID")) {
                        System.out.println("What is the new ID?");
                        Scanner tempScan = new Scanner(System.in);
                        String tempData = tempScan.next();
                        line2[0] = "";
                        line2[0] = tempData;
                    }
                    else if (tempUpdate.equals("Stock")) {
                        System.out.println("What is the new Stock?");
                        Scanner tempScan = new Scanner(System.in);
                        String tempData = tempScan.next();
                        line2[1] = "";
                        line2[1] = tempData;
                    }
                    else if (tempUpdate.equals("Wholesale")) {
                        System.out.println("What is the new Wholesale price?");
                        Scanner tempScan = new Scanner(System.in);
                        String tempData = tempScan.next();
                        line2[2] = "";
                        line2[2] = tempData;
                    }
                    else if (tempUpdate.equals("Sale")) {
                        System.out.println("What is the new sale price?");
                        Scanner tempScan = new Scanner(System.in);
                        String tempData = tempScan.next();
                        line2[3] = "";
                        line2[3] = tempData;
                    }
                    else if (tempUpdate.equals("Supplier")) {
                        System.out.println("What is the new supplier ID?");
                        Scanner tempScan = new Scanner(System.in);
                        String tempData = tempScan.next();
                        line2[4] = "";
                        line2[4] = tempData;
                    }
                }
                }
            }
		else if (userin.equalsIgnoreCase("Delete")) {
            		System.out.println("What row would you like to delete");
            		Scanner Rowline = new Scanner(System.in);
            		String Row = Rowline.next();
            			for (int i = 0; i < csvData.size(); i++) {

                			String line2[] = new String[5];
                			line2 = csvData.get(i);
                			if (Row.equals(line2[0])) {

                    			csvData.remove(i);

                    			System.out.println( line2[0]+ "" + "Has been deleted" );
                }
            }
        }	// System.out.println(Arrays.deepToString(csvData.toArray()));
	}

	public static List<String[]> reader() throws IOException {
		// open file input stream
		/**
		 * This method is the method that reads in the data from a csv file to an array list
		 * Hard coded file path at the moment that will change
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

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("USERNAME: ");
		String username = sc.next();
		System.out.println("PASSWORD: ");
		String password = sc.next();
		userpass(username, password);
		maniplation(reader());

	}
}
