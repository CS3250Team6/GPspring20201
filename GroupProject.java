import java.io.*;
import java.util.*;

class GroupProject {
	public static void adder(List<String[]> csvData) throws IOException {
		String line = null;
		Scanner scanner = null;
		int index = 0;
		/* List<String[]> csvData = new ArrayList<String[]>(); */
		System.out.println("What would you like to do to your data?: ");
		Scanner sysin = new Scanner(System.in);
		String userin = sysin.nextLine();
		if (userin.equals("add")) {
			System.out.println("please enter the data you would like to add seperated by commas");
			BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
			line = userinput.readLine();
			scanner = new Scanner(line);
			String line2[] = new String[6];
			scanner.useDelimiter(",");
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
					line2[5] = "in data array";
				} else
					System.out.println("invalid data::" + data);
				index++;
			}
			csvData.add(line2);
		}
		 System.out.println(Arrays.deepToString(csvData.toArray())); 
	}
	public static List<String[]>  reader () throws IOException{
		// open file input stream
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
						line2[5] = "in data array";
						index++;
					}
					index = 0;
					csvData.add(line2);

				}
				/* System.out.println(Arrays.deepToString(csvData.toArray())); */
				return csvData;

			}
	
	
	public static void main(String[] args) throws IOException {
		
		adder(reader());
		
}
}
