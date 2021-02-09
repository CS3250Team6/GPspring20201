import java.io.*;
import java.util.*;


class GroupProject {
	public static void main(String[] args) throws IOException {

		// open file input stream
		BufferedReader reader = new BufferedReader(new FileReader("inventory_team6.csv"));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		List<String[]> csvData = new ArrayList<String[]>();

		while ((line = reader.readLine()) != null) {
			String line2[] = new String[5];
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
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

		System.out.println(Arrays.deepToString(csvData.toArray()));

	}
}
