package Hotel;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Menu extends Application{
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
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/menu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
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
		launch(args);
		menu.saveInfo();
	}
}
