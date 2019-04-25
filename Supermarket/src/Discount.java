/**
 * 
 * @author Zied Tebourbi ObjectWare 2019
 *
 */
public class Discount {

	private String reference;
	private int discountItems;

	public Discount(String reference, int discountItems) {
		super();
		this.reference = reference;
		this.discountItems = discountItems;

	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getDiscountItems() {
		return discountItems;
	}

	public void setDiscoutItems(int discountItems) {
		this.discountItems = discountItems;
	}

}
