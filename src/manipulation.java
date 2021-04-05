import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class manipulation {

	public static List<String[]> add(List<String[]> csvData, String prodid, String quantity, String wholesale,
			String sale, String supplier) throws IOException {

		/**
		 * This method is the main method for manipulation of data in the array list The
		 * first part is the add part of manipulation
		 * 
		 * @param user input for the data that they want to enter it must be everything
		 *             (product_id,quantity,wholesale_cost,sale_price,supplier_id)
		 * @return doesn't return anything adds to csv array list
		 * @author Hunter Holton
		 */
		String line2[] = new String[5];
		line2[0] = prodid;
		line2[1] = quantity;
		line2[2] = wholesale;
		line2[3] = sale;
		line2[4] = supplier;

		csvData.add(line2);
		CSVWRITER.CSVWRITER("inventory_team6.csv", csvData);
		return csvData;
	}

	public static String[] search(List<String[]> csvData, String prodid) {
		String[] temp = new String[5];
		for (int i = 0; i < csvData.size(); i++) {

			String id = prodid;
			String line2[] = new String[5];
			line2 = csvData.get(i);
			if (id.equals(line2[0])) {
				temp = csvData.get(i);
				return temp;
			}
		}
		return temp;

	}

	public static List<String[]> update(List<String[]> csvData, String prodId, String colupdate, String update) {
		String[] temp = csvData.get(csvData.indexOf(prodId));
		if (colupdate.toLowerCase().equals("quantity")) {
			temp[1] = update;
			csvData.set(csvData.indexOf(prodId), temp);
		}
		if (colupdate.toLowerCase().equals("wholesale")) {
			temp[2] = update;
			csvData.set(csvData.indexOf(prodId), temp);

		}
		if (colupdate.toLowerCase().equals("quantity")) {
			temp[3] = update;
			csvData.set(csvData.indexOf(prodId), temp);
		}
		if (colupdate.toLowerCase().equals("quantity")) {
			temp[4] = update;
			csvData.set(csvData.indexOf(prodId), temp);
		}

		return csvData;

	}

	/**
	 * @param csvData
	 * @param prodid
	 * @param quantity
	 * @param wholesale
	 * @param sale
	 * @param supplier
	 * @return
	 */
	public static List<String[]> updateall(List<String[]> csvData, String prodid, String quantity, String wholesale,
			String sale, String supplier) {
		String[] temp = new String[5];
		int iterator = 0;
		for (int i = 0; i < csvData.size(); i++) {

			String id = prodid;
			String line2[] = new String[5];
			line2 = csvData.get(i);
			if (id.equals(line2[0])) {
				temp = csvData.get(i);
				iterator = i;
				break;
			}
		}
		String ret[] = new String[5];
		ret[0] = prodid;
		ret[1] = quantity;
		ret[2] = wholesale;
		ret[3] = sale;
		ret[4] = supplier;
		csvData.set(iterator, ret);

		return csvData;

	}

	public static List<String[]> delete(List<String[]> csvData, String prodid) throws IOException {

		String[] temp = new String[5];
		for (int i = 0; i < csvData.size(); i++) {

			String id = prodid;
			String line2[] = new String[5];
			line2 = csvData.get(i);
			if (id.equals(line2[0])) {
			
				csvData.remove(i);
				CSVWRITER.CSVWRITER("inventory_team6.csv", csvData);
				return csvData;
			}

		}
		return csvData;
	}
}

