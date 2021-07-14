package at.droll.div2builder.framework.inventory;

/**
 * Inventory Exception class
 */
@SuppressWarnings("serial")
public class InventoryException extends Exception {
	
	/**
	 * Parameterized constructor
	 * @param errorMessage Errror mesage to throw
	 */
	public InventoryException(String errorMessage) {		
		super(errorMessage);
	}
}