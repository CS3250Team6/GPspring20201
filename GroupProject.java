import java.io.*;
import java.util.*;
import java.awt.color;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


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
		JFrame frame = new HandleActionEventsForJButton();

	public class HandleActionEventsForJButton extends JFrame implements ActionListener {
   
   public HandleActionEventsForJButton() {
    // set flow layout for the frame
      this.getContentPane().setLayout(new FlowLayout());
    
      JButton button1 = new JButton("add Data");
      JButton button2 = new JButton("No");
    
    //set action listeners for buttons
      button1.addActionListener(this);
      button2.addActionListener(this);
    
    //Add buttons to the frame
      add(button1);
      add(button2);
   }
   @Override
   public void actionPerformed(ActionEvent ae) {
      String action = ae.getActionCommand();
      if (action.equals("add Data")) {
         System.out.println("Yes Button Pressed!");
      }
      else if (action.equals("N0")) {
         System.out.println("No Button Pressed!");
      }
   
   }
   private static void creatAndShowGUI() {
   // Create and set up the windo.
      JFrame frame = new HandleActionEventsForJButton();
   
   // Display the window
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   }
}
	
               
}
