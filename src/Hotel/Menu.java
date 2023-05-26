package Hotel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu extends Application{
	private ArrayList<Room> hotelRooms;
	private ArrayList<Person> Guests;
	private ArrayList<Staff> staffList;
	private HashMap<String, Integer> validItems;
	private Parent root;
	private Scene scene;
	private Stage stage;
	@FXML
	TextField Name;
	@FXML
	TextField Phone;
	@FXML
	Text PhoneError;
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
			root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
			scene = new Scene(root);
			stage = primaryStage;
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void guestMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("GuestMenu.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void staffMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("staffMenu.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void managementMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ManagementMenu.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void addRoomMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("addRoom.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void addGuestMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("addGuest.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void addStaffMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("addStaff.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void addRoom() {
		
	}
	private void removeRoom() {
		
	}
	public void addGuest(ActionEvent e) throws IOException{
		try {
			Guests.add(new Person(Name.getText(),Phone.getText()));
			guestMenu(e);
		}catch(IllegalArgumentException IAE) {
			PhoneError.setText(IAE.getMessage());
			PhoneError.setOpacity(1);
		}
	}
	private void removeGuest() {
		
	}
	public void addStaff(){
		
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
		validItems.put("Coca Cola", 15000);
		validItems.put("Water bottle", 10000);
		validItems.put("Pepsi", 14500);
		validItems.put("Heineken", 20000);
		validItems.put("Bud Light", 17000);
	}
	public static void main(String[] args) {
		Menu menu = new Menu();
		launch(args);
		menu.saveInfo();
	}
}
