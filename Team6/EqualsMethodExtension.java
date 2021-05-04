import java.util.Objects;

public class EqualsMethodExtension {


	    privet String firstColumen;    
	    privet String secondColumen; 
	    privet String thirdColumen;
	    privet String fourthColumen;     
	    privet String fivthColumen; 


	    public EqualsMethodExtension(productId, quantity, wholesale_cost,sales_price,supplier_Id) {
	        this.firstColumen = productId;
	        this.secondColumen = quantity ;
	        this.thirdColumen = wholesale_cost;
	        this.fourthColumen = sale_price;
	        this.fivthColumen = supplier_Id;
	    }


	    @Override
	    public int hashCode() {
	        int hash = 3;
	        hash += 97 * hash + Objects.hashCode(this.producttId);
	        hash += 97 * hash + Objects.hashCode(this.quantity);
	        hash += 97 * hash + Objects.hashCode(this.wholesale_cost);
	        hash += 97 * hash + Objects.hashCode(this.sale_price);
	        hash += 97 * hash + Objects.hashCode(this.supplier_Id);
	        return hash;
	    } // End hashCode



	    @Override
	    public boolean equals(Object obj) {
	//[Start]
	        boolean isEqual = false;
	        if (this == obj) {
	            return true;
	        }
	        // Make sure the object is not null
	        if (obj == null) {
	            return false;
	        }
	        // Makes sure class types are equivalent
	        if (getClass() != obj.getClass()) {
	            return false;
	        }

	 

	///  Here we check the individual fields for equality. Note the
	///     changes in the way fields are compared. 

	       
	        if ( Objects.equals(this.firstColumen, other.firstColumen) &&
	             Objects.equals(this.secondColumen, other.secondColumen) &&
	             Objects.equals(this.thirdColumen,  other.thirdColumen)  &&
	             Objects.equals(this.fourthColumen, other.fourthColumen) &&
	             Objects.equals(this.fivthColumen, other.fivthColumen)) {
	                isEqual = true;
	        }
	        return isEqual;
	    } // End equals
	} // End class



