import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class manipulation {

	public static List<String[]> add(List<String[]> csvData, String prodid, String quantity, String wholesale,
			String sale, String supplier) {

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
		return csvData;
	}

	public static String[] search(List<String[]> csvData, String prodid) {
		int temp = csvData.indexOf(prodid);
		String ret[] = new String[5];
		ret = csvData.get(temp);
		return ret;
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
		int index = csvData.indexOf(prodid);
		String ret[] = new String[5];
		ret[0] = prodid;
		ret[1] = quantity;
		ret[2] = wholesale;
		ret[3] = sale;
		ret[4] = supplier;
		csvData.set(index, ret);

		return csvData;

	}
	public static List<String[]> delte (List<String[]> csvData, String prodid){
		
		csvData.remove(csvData.indexOf(prodid));
		return csvData;
		
	}
}
