import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {
	public static void createGUI() throws IOException {
		List<String[]> csvData = reader.reader();
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
		add.addActionListener(new ActionListener() {
			List<String[]> temp;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					temp = manipulation.add(csvData, itemID.getText(), quantity.getText(), wholesaleCost.getText(),
							salePrice.getText(), suplierID.getText());
					System.out.println("Added" + Arrays.deepToString(temp.toArray()));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					CSVWRITER.CSVWRITER("test1", temp);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		JButton search = new JButton("Search");
		search.setBounds(30, 180, 100, 20);
		frame.add(search);
		JTextField searchBar = new JTextField("Enter ID");
		searchBar.setBounds(30, 200, 100, 20);
		frame.add(searchBar);
		JTextArea results = new JTextArea("Results");
		results.setBounds(30, 220, 100, 20);
		frame.add(results);
		search.addActionListener(new ActionListener() {
			String[] temp = new String[5];

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				temp = manipulation.search(csvData, searchBar.getText().toString());
				System.out.println(Arrays.deepToString(temp));

			}
		});

		JButton delete = new JButton("Delete");
		delete.setBounds(30, 260, 100, 20);
		frame.add(delete);
		JTextField deleteSearch = new JTextField("Enter Product ID");
		deleteSearch.setBounds(30, 280, 100, 20);

		frame.add(deleteSearch);
		delete.addActionListener(new ActionListener() {
			String[] temp = new String[5];
			List<String[]> temp1;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				temp = manipulation.search(csvData, deleteSearch.getText());
				temp1 = manipulation.delete(csvData, deleteSearch.getText());
				System.out.println("Deleted " + Arrays.deepToString(temp));
				try {
					CSVWRITER.CSVWRITER("inventory_team6.csv", temp1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

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
		update.addActionListener(new ActionListener() {

			List<String[]> temp1;

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				temp1 = manipulation.updateall(csvData, updateItemID.getText(), updateQuantity.getText(),
						updateWholesaleCost.getText(), updateSalePrice.getText(), updateSuplierID.getText());
				try {
					CSVWRITER.CSVWRITER("inventory_team6.csv", temp1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

	}
}
