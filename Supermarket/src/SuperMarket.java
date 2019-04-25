import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 
 * @author Zied Tebourbi ObjectWare 2019
 *
 */

public class SuperMarket {
	public Catalogue catalogue;

	public SuperMarket() {
		this.initCatalogue();
	}
	
	private boolean isInteger (String string)
    {
        try {
            Integer.parseInt (string);
            return true;
        } catch (NumberFormatException e) {
        	System.out.println(e.getMessage()+ " \t "+ "give a number value \n");
            return false;
        }
    }

	/***
	 * method that adds the products in our order
	 * 
	 * @param order
	 */
	public void addProduct(Order order) {
		Scanner sc = new Scanner(System.in);

		// add apple
		String appleQuantity;
		do {
			System.out.println("give the quantity of apple \n");
			appleQuantity = sc.next();

		} while (!isInteger(appleQuantity) || !(Integer.valueOf(appleQuantity) > 0));
		OrderItem appleorderItem = new OrderItem(this.catalogue.getListItems().stream()
				.filter(product -> product.getItem().equals(ProductType.APPLE.toString())).collect(Collectors.toList())
				.get(0), Integer.parseInt(appleQuantity));

		// add orange
		String orangeQuantity;
		do {
			System.out.println("give the quantity of orange \n");
			orangeQuantity = sc.next();
		} while (!isInteger(orangeQuantity) || !(Integer.valueOf(orangeQuantity) > 0));

		OrderItem orangeorderItem = new OrderItem(this.catalogue.getListItems().stream()
				.filter(product -> product.getItem().equals(ProductType.ORANGE.toString())).collect(Collectors.toList())
				.get(0), Integer.parseInt(orangeQuantity));
		// add Watermelon
		String WatermelonQuantity;
		do {
			System.out.println("give the quantity of Watermelon \n");
			WatermelonQuantity = sc.next();
		} while (!isInteger(WatermelonQuantity) || !(Integer.valueOf(WatermelonQuantity) > 0));
		OrderItem WatermelonorderItem = new OrderItem(this.catalogue.getListItems().stream()
				.filter(product -> product.getItem().equals(ProductType.WATERMELON.toString()))
				.collect(Collectors.toList()).get(0), Integer.parseInt(WatermelonQuantity));

		List<OrderItem> listOrderItem = new ArrayList<OrderItem>();
		listOrderItem.add(appleorderItem);
		listOrderItem.add(orangeorderItem);
		listOrderItem.add(WatermelonorderItem);
		order.setOrderItemsList(listOrderItem);

	}

	/***
	 * method that initializes the catalog and display it
	 */
	void initCatalogue() {
		StringBuilder catalog = new StringBuilder();
		Product apple = new Product(ProductType.APPLE.toString(), 0.20);
		Product orange = new Product(ProductType.ORANGE.toString(), 0.5);
		Product Watermelon = new Product(ProductType.WATERMELON.toString(), 0.8);
		List<Product> listProduct = new ArrayList<Product>();
		listProduct.add(apple);
		listProduct.add(orange);
		listProduct.add(Watermelon);
		this.catalogue = new Catalogue(listProduct);
		catalog.append("our catalog is \n");
		catalog.append("------------------------ \n");
		catalog.append("Item \t | Price \n");
		catalog.append("------------------------ \n");

		for (Product product : listProduct) {
			catalog.append(product.getItem() + "\t " + "|" + product.getPrice() + " \n");
			catalog.append("------------------------ \n");

		}
		System.out.println(catalog.toString());

	}
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SuperMarket superMarket = new SuperMarket();
		byte choice = 0;

		while (choice != 2) {

			String choiceSr;
			 do {
				System.out.println("1: pay");
				System.out.println("2: Exit");
				choiceSr = sc.next();
				choice = Byte.valueOf(choiceSr);
				if (choice == 1) {

					Order newOrder = new Order();
					superMarket.addProduct(newOrder);
					newOrder.calculateOrderPrice();
					System.out.println(newOrder.toString());
				}
			} while (!superMarket.isInteger(choiceSr));

		}
		
	}

}
