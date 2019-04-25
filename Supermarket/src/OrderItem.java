/**
 * 
 * @author Zied Tebourbi ObjectWare 2019
 *
 */

public class OrderItem {
	private Product myProduct;
	private int quantity;
	private double price;

	public OrderItem(Product myProduct, int quantity) {
		
		this.myProduct = myProduct;
		this.quantity = quantity;
	}
	

	public OrderItem(Product myProduct, int quantity, double price) {
		super();
		this.myProduct = myProduct;
		this.quantity = quantity;
		this.price = price;
	}
/***
 * Method that calculates the price of a command line
 */
	public void calculateorderItemPrice() {
		price = 0.0;
		if (myProduct.getPrice() > 0) {
			price = quantity * myProduct.getPrice();
		}

	}
	public Product getMyProduct() {
		return myProduct;
	}

	public void setMyProduct(Product myProduct) {
		this.myProduct = myProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
