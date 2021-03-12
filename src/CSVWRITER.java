import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWRITER {
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
}