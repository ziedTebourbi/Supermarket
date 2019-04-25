/**
 * 
 * @author Zied Tebourbi ObjectWare 2019
 *
 */
public class Product {

	private String item;
	private double price;
	

	public Product(String item, double price) {
		super();
		this.item = item;
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
