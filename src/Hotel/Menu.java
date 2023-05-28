package Hotel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu extends Application implements Initializable{
	private ArrayList<Room> hotelRooms;
	private ArrayList<Person> Guests;
	private ArrayList<Staff> staffList;
	private HashMap<String, Integer> validItems;
	private Parent root;
	private Scene scene;
	private Stage stage;
	private int test = 0;
	@FXML
	TextField Name;
	@FXML
	TextField Phone;
	@FXML
	TextField id2;
	@FXML
	Text PhoneError;
	@FXML
	FlowPane List;
	@FXML
	ChoiceBox<Character> id1;
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
	public void initialize(URL arg0, ResourceBundle arg1){
		System.out.println(test);
		if(arg0.equals(getClass().getResource("GuestMenu.fxml"))) {
			for(Person G: Guests) {
				VBox guestInfo = new VBox();
				guestInfo.getChildren().add(new Text(G.getName()));
				guestInfo.getChildren().add(new Text(G.getPhone()));
				guestInfo.getChildren().add(new Text(G.getRoomNumber()!=-1?Integer.toString(G.getRoomNumber()):"None"));
				guestInfo.setAlignment(Pos.TOP_CENTER);
				guestInfo.setPrefWidth(80);
				guestInfo.setBorder(new Border(new BorderStroke(null,BorderStrokeStyle.SOLID,null,null)));
				List.getChildren().add(guestInfo);
			}
			return;
		}
		if(arg0.equals(getClass().getResource("StaffMenu.fxml"))) {
			for(Staff S: staffList) {
				VBox staffInfo = new VBox();
				staffInfo.getChildren().add(new Text(S.getName()));
				staffInfo.getChildren().add(new Text(S.getPhone()));
				staffInfo.getChildren().add(new Text(S.getStaffID()));
				staffInfo.setAlignment(Pos.TOP_CENTER);
				staffInfo.setPrefWidth(80);
				staffInfo.setBorder(new Border(new BorderStroke(null,BorderStrokeStyle.SOLID,null,null)));
				List.getChildren().add(staffInfo);
			}
			return;
		}
		if(arg0.equals(getClass().getResource("ManagementMenu.fxml"))) {
			for(Room R: hotelRooms) {
				VBox roomInfo = new VBox();
				roomInfo.getChildren().add(new Text(Integer.toString(R.getRoomNumber())));
				roomInfo.getChildren().add(new Text(R.getType()));
				roomInfo.getChildren().add(new Text(Integer.toString(R.getCostPerNight())));
				roomInfo.getChildren().add(new Text(R.getAvailability()?"Available":"Occupied"));
				roomInfo.setPrefWidth(95);
				roomInfo.setAlignment(Pos.TOP_CENTER);
				roomInfo.setBorder(new Border(new BorderStroke(null,BorderStrokeStyle.SOLID,null,null)));
				List.getChildren().add(roomInfo);
			}
			return;
		}
		if(arg0.equals(getClass().getResource("addStaff.fxml"))) {
			Character[] id = {'M','F'};
			id1.getItems().addAll(id);
		}
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
		root = FXMLLoader.load(getClass().getResource("StaffMenu.fxml"));
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
			for(Person Guest: Guests) {
				System.out.println(Guest.getDetails());
			}
			System.out.println("----------------------------------");
			guestMenu(e);
			for(Person Guest: Guests) {
				System.out.println(Guest.getDetails());
			}
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
		try {
			File guestFile = new File("StaffList.txt");
			Scanner input = new Scanner(guestFile);
			
			while (input.hasNextLine()) {
				String aString = input.nextLine();
				String[] parts = aString.split(",");
				Staff s1 = new Staff(parts[0], parts[1], parts[2]);
				staffList.add(s1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void loadGuests() {
		// TODO Auto-generated method stub
		try {
			File guestFile = new File("GuestList.txt");
			Scanner input = new Scanner(guestFile);
			
			while (input.hasNextLine()) {
				String aString = input.nextLine();
				String[] parts = aString.split(",");
				Person p1 = new Person(parts[0], parts[1]);
				Guests.add(p1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void loadhotelRooms() {
		// TODO Auto-generated method stub
		try {
			File guestFile = new File("RoomList.txt");
			Scanner input = new Scanner(guestFile);
			
			while (input.hasNextLine()) {
				String aString = input.nextLine();
				String[] parts = aString.split(",");
				Room r1 = new Room(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));
				hotelRooms.add(r1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
