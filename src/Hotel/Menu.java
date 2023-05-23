package Hotel;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
	private ArrayList<Room> hotelRooms;
	private ArrayList<Person> Guests;
	private ArrayList<Staff> staffList;
	private HashMap<String, Integer> validItems;
	public Menu() {
		hotelRooms = new ArrayList<Room>();
		Guests = new ArrayList<Person>();
		staffList = new ArrayList<Staff>();
		validItems = new HashMap<String,Integer>();
		loadhotelRooms();
		loadGuests();
		loadStaffList();
		loadValidItems();
		Fridge.addAllValidItems(validItems);
		// TODO Auto-generated constructor stub
	}

	private void addRooms() {
		
	}
	private void removeRooms() {
		
	}
	private void addGuest() {
		
	}
	private void removeGuest() {
		
	}
	private void addStaff() {
		
	}
	private void removeStaff() {
		
	}
	private void saveInfo() {
		
	}
	private void loadStaffList() {
		// TODO Auto-generated method stub
	}

	private void loadGuests() {
		// TODO Auto-generated method stub
		
	}

	private void loadhotelRooms() {
		// TODO Auto-generated method stub
		
	}
	private void loadValidItems() {
		
	}
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.saveInfo();
	}
}
