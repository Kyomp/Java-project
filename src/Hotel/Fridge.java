package Hotel;

import java.util.HashMap;
import java.util.List;

public class Fridge {
	private HashMap<String,Integer> contents;
	private static HashMap<String,Integer> validItems = new HashMap<String,Integer>();
	
	public Fridge() {
		contents = new HashMap<String,Integer>();
	}
	public Fridge(List<String> contents) {
		for(String item : contents) {
			if(!validItems.containsKey(item)) {
				throw new IllegalArgumentException(item + " is not a valid item to put in the fridge");
			}
			if(this.contents.containsKey(item)) {
				this.contents.put(item, this.contents.get(item)+1);
			}
			else {
				this.contents.put(item, 1);
			}
		}
	}
	
	public void removeItem() {
		
	}
	public static void addAllValidItems(HashMap<String,Integer> validItems) {
		Fridge.validItems.putAll(validItems);
	}
	public static void addValidItem(String name, Integer price) {
		Fridge.validItems.put(name,price);
	}
	public static void addValidItem(String name, int price) {
		Fridge.validItems.put(name, Integer.valueOf(price));
	}
	
}
