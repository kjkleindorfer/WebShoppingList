import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.ListItem;
import model.Shopper;
import model.ListDetails;

public class TestShoppingList {
	public static void main(String[] args) {
		
		Shopper dad = new Shopper("Kelli");
	
		
		ListDetails dadList = new ListDetails("Mom's List", LocalDate.now(), dad);
		
		ListItem a = new ListItem("Target", "Peaches");
		ListItem b = new ListItem("Target", "Oranges");
		
		List<ListItem> qwerty = new ArrayList<ListItem>();
		qwerty.add(a);
		qwerty.add(b);
		dadList.setListOfItems(qwerty);
		
		ListDetailsHelper sl = new ListDetailsHelper();
		
		
		
		sl.insertNewListDetails(dadList);
				
		System.out.println(dadList.toString());		
		
		
		
		List<ListDetails> abc = sl.getLists();
		
		for(ListDetails z: abc) {
		System.out.println(z.toString());
		}
	}


}
