import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GroupProject {

	
	public static void main(String[] args) throws IOException {

		boolean cont = true;
		boolean cont2 = true;
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
			if (userpass.userpass(exist, username, password)) {
                while (cont2) {
                    GUI newGUI = new GUI();
                    newGUI.createGUI();
                    String temp = sc.next();
                    if (temp.equals("yes")) {
                        cont2 = true;
                    } else {
                        cont2 = false;
                        System.exit(1);
                    }
                }
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
