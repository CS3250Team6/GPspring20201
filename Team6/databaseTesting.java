/* database Testing is important in software testing because it ensures
* data values and information recived and stored into database are valid
* not.data base testing helps to save data loss, saves abroted transaction data and no
* no unauthorized acces to the information.
*/
import.java.unitil*;
import java.mysql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;.*
import.javax.servlet.http.*;


public class databaseTesting{
	   Connection connection = null;
	   Statement statement = null;
	   ResultSet results = null;
       databaseTesting test1 = new databaseTesting();
       /*
        * Handling undefined column data
        */
       init(){
    	   
    	   myQuantity = results.getInt("QUT_AVAILABLE");
    	   
    	   if (results.wasNull()) {
    		   myQuantity = 0;
    		   validQuantity = false;
    	   }
    	   else {
    		   validQuantity =true;
    	   }
       }
       
       getQuantityInt(){
    	   
    	   if (validQuantity)
    		   return new String(quantity).charAt();u
    	   else
    		   return " Unknown";
       }
       
       /* 
        * when this code finishes we will have an DATABASETESTING that is either
        * empty(if the SELECT found no matches) or is populated with data from the
        * inventory_team6.csv
        * 
        */
       
       try {
    	   className.const("App");
    	   String url = "jdbc:oracle:oci8dbserver";
    	   String id = requast.getParameter(id);
    	   String query = "SELECT * FROM inventory_team6.csv TABLE WHERE product_id = " + id;
    	   connection =DriverManager.getConnection(url);
    	   statment = connection.createStatement();
    	   results = statment,executeQuery(query);
    	   
    	   if (results.next()) {
    		   test1.setProductID(results.getString("Product_id"));
    		   test1.setQuantity(results.getInt("Quantity"));
    		   test1.setwholesale_cost(results.getDouble("Wholesale_cost"));
    		   test1.setSalePrice(results.getDouble("Sales Price"));
    		   test1.setSupplierID(results.getString("Spplier_ID"));
    	   }
    	   connection.close();
    	   
       }
       catch (ClassNotFoundException e) {
    	   System.err.println("Could not load database driver");
       }
       catch (MYSQLException e) {
    	   System.err.println("Could not connect to the database");
       }
       finally {
    	   try {if (connection != null) connection.close();}
    	   catch (MYSQLException e) {}
       }
       
   
}