import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Zied Tebourbi ObjectWare 2019
 *
 */

public class Offer {

	public static final int DISCOUNT = -1;
	private Map<String, Discount> mapDiscount;

	public Offer() {
		initOffre();
	}

	public Offer(Map<String, Discount> mapDiscount) {
		this.mapDiscount = mapDiscount;
	}

	public void initOffre() {
		Discount appleDiscount = new Discount(ProductType.APPLE.toString(), 2);
		Discount watermelonDiscount = new Discount(ProductType.WATERMELON.toString(), 3);
		mapDiscount = new HashMap<String, Discount>();
		mapDiscount.put(ProductType.APPLE.toString(), appleDiscount);
		mapDiscount.put(ProductType.WATERMELON.toString(), watermelonDiscount);

	}
/***
 * Method that applies the offer for each order line
 * @param order
 * @param orderItem
 * @return OrderItem
 */
	public OrderItem applicateOffer(Order order, OrderItem orderItem) {
		OrderItem offreOrderItem = null;
		Discount discount = mapDiscount.get(orderItem.getMyProduct().getItem());
		if (discount != null) {
			int quantity = orderItem.getQuantity() / discount.getDiscountItems();
			quantity = quantity * DISCOUNT;
			offreOrderItem = new OrderItem(orderItem.getMyProduct(), quantity,
					quantity * orderItem.getMyProduct().getPrice());
		}
		return offreOrderItem;
	}

	public Map<String, Discount> getMapDiscount() {
		return mapDiscount;
	}

	public void setMapDiscount(Map<String, Discount> mapDiscount) {
		this.mapDiscount = mapDiscount;
	}

}
