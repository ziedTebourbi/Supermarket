import java.util.List;

/**
 * 
 * @author Zied Tebourbi ObjectWare 2019
 *
 */
public class Catalogue {

	private List<Product> listItems;

	public Catalogue(List<Product> listItems) {
		this.listItems = listItems;
	}

	public List<Product> getListItems() {
		return listItems;
	}

	public void setListItems(List<Product> listItems) {
		this.listItems = listItems;
	}

}
