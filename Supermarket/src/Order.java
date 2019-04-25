import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Zied Tebourbi ObjectWare 2019
 *
 */

public class Order {
	public static final int EMPTY = 0;
	private String reference;
	private List<OrderItem> orderItemsList;
	private double orderPrice;

	public Order(String reference, List<OrderItem> orderItemsList) {
		this.reference = reference;
		this.orderItemsList = orderItemsList;
	}

	public Order() {
	}

	/**
	 * Method that calculates the total price of the order
	 */
	public void calculateOrderPrice() {
		Offer offer = new Offer();
		orderItemsList.stream().forEach(orderItem -> {
			orderItem.calculateorderItemPrice();
		});
		List<OrderItem> orderItemsOffreList = new ArrayList<OrderItem>();
		for (OrderItem orderItem : orderItemsList) {
			OrderItem orderItemoffer = offer.applicateOffer(this, orderItem);
			if (orderItemoffer != null) {

				orderItemsOffreList.add(orderItemoffer);

			}
		}
		if (orderItemsOffreList.size() > EMPTY) {
			orderItemsList.addAll(orderItemsOffreList);

		}

		setOrderPrice(orderItemsList.stream().mapToDouble(f -> f.getPrice()).sum());

	}

	@Override
	public String toString() {
		StringBuilder receipt = new StringBuilder();
		receipt.append("-------------------------------------------------------------- \n");
		receipt.append("Item \t | Unit Price \t | Quantity \t | total Price for Item \n");
		receipt.append("-------------------------------------------------------------- \n");

		for (OrderItem orderItem : orderItemsList) {
			receipt.append(orderItem.getMyProduct().getItem() + " \t | " + orderItem.getMyProduct().getPrice()
					+ " \t | " + orderItem.getQuantity() + "\t |" + orderItem.getPrice() + "\n");
			receipt.append("-------------------------------------------------------------- \n");
		}
		receipt.append("TOTAL PRICE" + " \t | " + orderPrice);
		receipt.append("\n");
		receipt.append("Thanks ! See You Soon!");
		return receipt.toString();

	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public List<OrderItem> getOrderItemsList() {
		return orderItemsList;
	}

	public void setOrderItemsList(List<OrderItem> orderItemsList) {
		this.orderItemsList = orderItemsList;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

}
