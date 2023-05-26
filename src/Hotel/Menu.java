package Hotel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Menu extends Application{
	private ArrayList<Room> hotelRooms;
	private ArrayList<Person> Guests;
	private ArrayList<Staff> staffList;
	private HashMap<String, Integer> validItems;
	private Parent root;
	private Scene scene;
	private Stage stage;
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
	private void addRoom() {
		
	}
	private void removeRoom() {
		
	}
	private void addGuest(){
		
	}
	private void removeGuest() {
		
	}
	private void addStaff(){

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
