import java.io.*;
import java.util.*;

class GroupProject {
    
    /*@param user  checking user securrity
      @param pass  Checking user password
    */
	private static void userpass(String user, String pass) {
	    
		if (user.equals("user") && pass.equals("pass")) {

			System.out.println("you are an authorized user");
		}

		else {
			System.exit(0);
		}
	}
    //***********************************************
    public static remove (int dataIndex) {
	String[] result = null;
	if ((dataIndex >= 1) && (dataIndex <= userInput)) {
	    // Assertion: !isEmpty()
	    if (dataIndex == 1)  // Case 1: Remove first entry
		result = index1.readLine(); // Save entry to be removed
	    index1 = index1.readNextIndex(); // Remove entry
	    else {
		Index indexBefore =readLine(dataIndex - 1);
		Index indexToRemove = indexBefore.readNextIndex();
		result = indexTORemove.readLine(); // save entry to be removed
		Index indexAfter = indexToRemove.readNextIndex();
		indexBefore.readNextIndex(indexAfter); // Remove entry
	    } // End if
	    userInput---;  // update count
	    return result;   // Return removed entry
	}
	else
	    throw new IndexOutOfBoundsException(" Illegal Index given to remove operation.")
		} // End Remove

    //***************************************************************
	
	
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
			String line2[] = new String[6];
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
		// System.out.println(Arrays.deepToString(csvData.toArray()));
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
			String line2[] = new String[6];
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
