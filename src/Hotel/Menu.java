package Hotel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.BasicFileAttributeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu extends Application implements Initializable{
	private ArrayList<Room> hotelRooms;
	private ArrayList<Person> Guests;
	private ArrayList<Staff> staffList;
	private HashMap<String, Integer> serviceList = Service.getServiceList();
	private Set<String> ID_List;
	private Set<Integer> RoomNums;
	private Parent root;
	private Scene scene;
	private Stage stage;
	private Encryption GDEncrypt, GLEncrypt, RDEncrypt, RLEncrypt, SDEncrypt, SLEncrypt;
	@FXML
	TextField Name;
	@FXML
	TextField Phone;
	@FXML
	TextField roomNumber;
	@FXML
	TextField roomCost;
	@FXML
	TextField NameDetail;
	@FXML
	TextField PhoneDetail;
	@FXML
	TextField RoomNumberDetail;
	@FXML
	TextField RemainingChargeDetail;
	@FXML
	TextField IDDetail;
	@FXML
	TextField WageDetail;
	@FXML
	TextField RoomTypeDetail;
	@FXML
	TextField RoomGuest;
	@FXML
	Text PhoneError;
	@FXML
	Text ID_error;
	@FXML
	Text lowWage;
	@FXML
	Text RoomError;
	@FXML
	Text PriceError;
	@FXML
	Text assignError;
	@FXML
	Text chargeRoomError;
	@FXML
	FlowPane List;
	@FXML
	Spinner<Integer> ID_num;
	@FXML
	Spinner<Integer> HourlyWage;
	@FXML
	ChoiceBox<Character> ID_gender;
	@FXML
	ChoiceBox<String> ChargeServices;
	@FXML
	ChoiceBox<String> roomType;
	SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 999);
	SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 2147483647);
	public Menu() {
		hotelRooms = new ArrayList<Room>();
		Guests = new ArrayList<Person>();
		staffList = new ArrayList<Staff>();
		ID_List = new HashSet<String>();
		RoomNums = new HashSet<Integer>();
		try {
			GDEncrypt = new Encryption(Files.getFileAttributeView(Paths.get(new File("GuestDetail.csv").getAbsolutePath()), BasicFileAttributeView.class).readAttributes().creationTime().toString());
			GLEncrypt = new Encryption(Files.getFileAttributeView(Paths.get(new File("GuestList.csv").getAbsolutePath()), BasicFileAttributeView.class).readAttributes().creationTime().toString());
			SDEncrypt = new Encryption(Files.getFileAttributeView(Paths.get(new File("StaffDetail.csv").getAbsolutePath()), BasicFileAttributeView.class).readAttributes().creationTime().toString());
			SLEncrypt = new Encryption(Files.getFileAttributeView(Paths.get(new File("StaffList.csv").getAbsolutePath()), BasicFileAttributeView.class).readAttributes().creationTime().toString());
			RDEncrypt = new Encryption(Files.getFileAttributeView(Paths.get(new File("RoomDetail.csv").getAbsolutePath()), BasicFileAttributeView.class).readAttributes().creationTime().toString());
			RLEncrypt = new Encryption(Files.getFileAttributeView(Paths.get(new File("RoomList.csv").getAbsolutePath()), BasicFileAttributeView.class).readAttributes().creationTime().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		for(Person G: Guests) {
			System.out.println(G.getDetails());
		}
		if(arg0.equals(getClass().getResource("GuestMenu.fxml"))) {
			loadGuests();
			for(Person G: Guests) {
				VBox guestInfo = new VBox();
				guestInfo.getChildren().add(new Text(G.getName()));
				guestInfo.getChildren().add(new Text(G.getPhone()));
				guestInfo.getChildren().add(new Text(G.getRoomNumber()!=-1?Integer.toString(G.getRoomNumber()):"None"));
				guestInfo.setAlignment(Pos.TOP_CENTER);
				guestInfo.setPrefWidth(80);
				guestInfo.setBorder(new Border(new BorderStroke(null,BorderStrokeStyle.SOLID,new CornerRadii(10.0),null)));
				if(G.getRoomNumber() == -1) {
					guestInfo.setStyle("-fx-background-color: \"#ffdb78\"; -fx-background-radius: 10px;");
				} else {
					guestInfo.setStyle("-fx-background-color: \"#ffbaf7\"; -fx-background-radius: 10px;");
				}
				guestInfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
				    @Override
				    public void handle(MouseEvent mouseEvent) {
				        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
				            if(mouseEvent.getClickCount() == 2){
				            	try {
				            		saveGuestDetail(G);
				            		guestDetailsMenu(guestInfo);
				            	}
				                catch(IOException e) {
				                	e.printStackTrace();
				                }
				            }
				        }
				    }
				});
				List.getChildren().add(guestInfo);
//				saveGuest();
			}
			return;
		}
		if(arg0.equals(getClass().getResource("StaffMenu.fxml"))) {
			loadStaffList();
			for(Staff S: staffList) {
				VBox staffInfo = new VBox();
				staffInfo.setStyle("-fx-background-color: \"#ffdb78\"; -fx-background-radius: 10px;");
				staffInfo.getChildren().add(new Text(S.getName()));
				staffInfo.getChildren().add(new Text(S.getPhone()));
				staffInfo.getChildren().add(new Text(S.getStaffID()));
				staffInfo.setAlignment(Pos.TOP_CENTER);
				staffInfo.setPrefWidth(80);
				staffInfo.setBorder(new Border(new BorderStroke(null,BorderStrokeStyle.SOLID,new CornerRadii(10.0),null)));
				staffInfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
				    @Override
				    public void handle(MouseEvent mouseEvent) {
				        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
				            if(mouseEvent.getClickCount() == 2){
				            	try {
				            		saveStaffDetail(S);
					                staffDetailsMenu(staffInfo);
				            	}
				            	catch(IOException e) {
				            		e.printStackTrace();
				            	}
				            }
				        }
				    }
				});
				List.getChildren().add(staffInfo);
//				saveStaff();
			}
			return;
		}
		if(arg0.equals(getClass().getResource("ManagementMenu.fxml"))) {
			loadhotelRooms();
			for(Room R: hotelRooms) {
				VBox roomInfo = new VBox();
				if(R.getAvailability() == true) {
					roomInfo.setStyle("-fx-background-color: \"#ffdb78\"; -fx-background-radius: 10px;");
				} else {
					roomInfo.setStyle("-fx-background-color: \"#ff5454\"; -fx-background-radius: 10px;");
				}
				roomInfo.getChildren().add(new Text(Integer.toString(R.getRoomNumber())));
				roomInfo.getChildren().add(new Text(R.getType()));
				roomInfo.getChildren().add(new Text(Integer.toString(R.getCostPerNight())));
				roomInfo.getChildren().add(new Text(R.getAvailability()?"Available":"Occupied"));
				roomInfo.setPrefWidth(95);
				roomInfo.setAlignment(Pos.TOP_CENTER);
				roomInfo.setBorder(new Border(new BorderStroke(null,BorderStrokeStyle.SOLID,new CornerRadii(10.0),null)));
				roomInfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
				    @Override
				    public void handle(MouseEvent mouseEvent) {
				        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
				            if(mouseEvent.getClickCount() == 2){
				            	try {
				            		saveRoomDetail(R);
					                roomDetailsMenu(roomInfo);
				            	}
				            	catch(IOException e) {
				            		e.printStackTrace();
				            	}
				            }
				        }
				    }
				});
				List.getChildren().add(roomInfo);
//				saveRoom();
			}
			return;
		}
		if(arg0.equals(getClass().getResource("addStaff.fxml"))) {
			Character[] gender = {'F','M'};
			ID_gender.getItems().addAll(gender);
			ID_gender.setValue('F');
			valueFactory.setValue(1);
			ID_num.setValueFactory(valueFactory);
			valueFactory2.setValue(25000);
			HourlyWage.setValueFactory(valueFactory2);
			return;
		}
		if(arg0.equals(getClass().getResource("addRoom.fxml"))) {
			String[] type = {"Standard", "Special Standard", "Deluxe", "Executive"};
			roomType.getItems().addAll(type);
			roomType.setValue("Standard");
			return;
		}
		if(arg0.equals(getClass().getResource("GuestDetails.fxml"))) {
			Person G = loadGuestDetail();
			NameDetail.setText(G.getName());
			PhoneDetail.setText(G.getPhone());
			RoomNumberDetail.setText(G.getRoomNumber()!=-1?Integer.toString(G.getRoomNumber()):"None");
			RemainingChargeDetail.setText(Integer.toString(G.getUnpaidCost()));
			return;
		}
		if(arg0.equals(getClass().getResource("StaffDetails.fxml"))) {
			Staff S = loadStaffDetail();
			NameDetail.setText(S.getName());
			PhoneDetail.setText(S.getPhone());
			IDDetail.setText(S.getStaffID());
			WageDetail.setText(Integer.toString(S.getHourlyWage()));
			return;
		}
		if(arg0.equals(getClass().getResource("RoomDetails.fxml"))) {
			Room R = loadRoomDetail();
			roomNumber.setText(Integer.toString(R.getRoomNumber()));
			RoomTypeDetail.setText(R.getType());
			roomCost.setText(Integer.toString(R.getCostPerNight()));
			if(R.getGuest()==null) {
				RoomGuest.setText("None");
				RoomGuest.setDisable(true);
			}
			else {
				RoomGuest.setText(R.getGuest().getName());
			}
			return;
		}
		if(arg0.equals(getClass().getResource("ChargeGuest.fxml"))) {
			loadGuests();
			loadhotelRooms();
			Person G = loadGuestDetail();
			int roomFee = 0;
			for(Room r : hotelRooms) {
				if(r.getRoomNumber() == G.getRoomNumber()) {
					roomFee = r.getCostPerNight();
				}
			}
			NameDetail.setText(G.getName());
			ArrayList<String> prices = new ArrayList<String>();
			prices.add("Room fee");
			for(Map.Entry<String, Integer> entry : serviceList.entrySet()) {
				prices.add(entry.getKey());
			}
			ChargeServices.getItems().addAll(prices);
			ChargeServices.setValue("Room fee");
			ChargeServices.setOnAction(event -> {
				if(ChargeServices.getValue()=="Room fee") {
					int room_Fee = 0;
					for(Room r : hotelRooms) {
						if(r.getRoomNumber() == G.getRoomNumber()) {
							room_Fee = r.getCostPerNight();
						}
					}
					RemainingChargeDetail.setText(Integer.toString(room_Fee));
					return;
				}
			    RemainingChargeDetail.setText(Integer.toString(Service.getServiceList().get(ChargeServices.getValue())));
			});
			RemainingChargeDetail.setText(Integer.toString(roomFee));
			return;
		}
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
			root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("FlowTel");
			stage = primaryStage;
			stage.getIcons().add(new Image("file:../../logo.jpg"));
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
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void staffMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("StaffMenu.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void managementMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ManagementMenu.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void addRoomMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("addRoom.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void addGuestMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("addGuest.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void addStaffMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("addStaff.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void guestDetailsMenu(Node e) throws IOException{
		root = FXMLLoader.load(getClass().getResource("GuestDetails.fxml"));
		stage = (Stage)(e.getScene().getWindow());
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void roomDetailsMenu(Node e) throws IOException{
		root = FXMLLoader.load(getClass().getResource("RoomDetails.fxml"));
		stage = (Stage)(e.getScene().getWindow());
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void staffDetailsMenu(Node e) throws IOException{

		root = FXMLLoader.load(getClass().getResource("StaffDetails.fxml"));
		stage = (Stage)(e.getScene().getWindow());
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void assignGuestRoomMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("AssignGuestRoom.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void chargeGuestMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ChargeGuest.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void addRoom(ActionEvent e) throws IOException {
		try {
			loadhotelRooms();
			RoomError.setOpacity(0);
			PriceError.setOpacity(0);
			if(!roomNumber.getText().matches("[0-9]+")) {
				throw new IllegalArgumentException("Room number can only contain numbers");
			}
			Integer num = Integer.parseInt(roomNumber.getText());
			if(RoomNums.contains(num)) {
				throw new IllegalArgumentException("Room number already exists");
			}
			if(!roomCost.getText().matches("[0-9]+")) {
				throw new IllegalArgumentException("Room price can only contain numbers");
			}
			hotelRooms.add(new Room(num.intValue(), roomType.getValue(), Integer.parseInt(roomCost.getText())));
			RoomNums.add(num);
			saveRoom();
			managementMenu(e);
		}catch(IllegalArgumentException IAE) {
			if(IAE.getMessage().contains("Room number")) {
				RoomError.setText(IAE.getMessage());
				RoomError.setOpacity(1);
			}
			else {
				System.out.println("shitf");
				PriceError.setText(IAE.getMessage());
				PriceError.setOpacity(1);
			}
		}
	}
	public void addGuest(ActionEvent e) throws IOException{
		try {
			loadGuests();
			Guests.add(new Person(Name.getText(),Phone.getText()));
			saveGuest();
			guestMenu(e);
		}catch(IllegalArgumentException IAE) {
			PhoneError.setText(IAE.getMessage());
			PhoneError.setOpacity(1);
		}
	}
	public void CheckOut(ActionEvent e)throws IOException{
		loadGuests();
		loadhotelRooms();
		Person G = loadGuestDetail();
		for(Room r : hotelRooms) {
			if(r.getRoomNumber()==(G.getRoomNumber())) {
				r.checkOut();
			}
		}
		for(Person p: Guests) {
			if(p.equals(G)) {
				p.checkOut();
			}
		}
		saveGuest();
		saveRoom();
		guestMenu(e);
	}
	public void removeGuest(ActionEvent e) throws IOException{
		loadGuests();
		loadhotelRooms();
		Person G = loadGuestDetail();
		for(Room r : hotelRooms) {
			if(r.getRoomNumber()==(G.getRoomNumber())) {
				r.checkOut();
			}
		}
		Guests.remove(G);
		saveGuest();
		saveRoom();
		guestMenu(e);
	}
	public void assignGuest(ActionEvent e) throws IOException{
		try {
			loadGuests();
			loadhotelRooms();
			assignError.setOpacity(0);
			for(Room r : hotelRooms) {
				if(r.getRoomNumber() == Integer.parseInt(RoomNumberDetail.getText())) {
					if(r.getAvailability() == false) {
						throw new IllegalArgumentException("This room is already assigned to another guest");
					}
				}
			}
			if(!RoomNums.contains(Integer.parseInt(RoomNumberDetail.getText()))) {
				throw new IllegalArgumentException("This room does not exist");
			}
			Person G = loadGuestDetail();
			for(Person Guest : Guests) {
				if(Guest.equals(G)) {
					Guest.checkIn(Integer.parseInt(RoomNumberDetail.getText()));
				}
			}
			for(Room r : hotelRooms) {
				if(r.getRoomNumber() == G.getRoomNumber()) {
					r.checkOut();
				}
			}
			for(Room r : hotelRooms) {
				if(r.getRoomNumber() == Integer.parseInt(RoomNumberDetail.getText())) {
					r.checkIn(G);
				}
			}
			
			saveGuest();
			saveRoom();
			guestMenu(e);
		} catch (IllegalArgumentException IAE) {
			if(IAE.getMessage().contains("already assigned")) {
				assignError.setText(IAE.getMessage());
				assignError.setOpacity(1);
			}
			else {
				assignError.setText(IAE.getMessage());
				assignError.setOpacity(1);
			}
		}
		
	}
	public void chargeGuestService(Person P){
		Integer cost = serviceList.get(ChargeServices.getValue());
		P.charge(cost);
		for (Person G : Guests) {
			if(G.equals(P)) {
				G.charge(cost);
			}
		}
		saveGuest();
	}
	public void chargeGuestRoom(ActionEvent e) throws IOException{
		try {
			chargeRoomError.setOpacity(0);
			loadhotelRooms();
			loadGuests();
			Person P = loadGuestDetail();
			
			if(ChargeServices.getValue() == null) {
				throw new IllegalArgumentException("Service not selected");
			}
			if(ChargeServices.getValue().equals("Room fee")) {
				if(P.getRoomNumber() == -1) {
					throw new IllegalArgumentException("This guest is not staying in a room.");
				}
				Integer cost = Integer.parseInt(RemainingChargeDetail.getText());
				for (Person G : Guests) {
					if(G.equals(P)) {
						G.charge(cost);
					}
				}
			}
			else {
				Integer cost = Integer.parseInt(RemainingChargeDetail.getText());
				for (Person G : Guests) {
					if(G.equals(P)) {
						G.charge(cost);
					}
				}
			}
			saveGuest();
			guestMenu(e);
		} catch (IllegalArgumentException IAE) {
			chargeRoomError.setText(IAE.getMessage());
			chargeRoomError.setOpacity(1);
		}
		
	}
	public void removeStaff(ActionEvent e) throws IOException{
		loadStaffList();
		Staff S = loadStaffDetail();
		staffList.remove(S);
		saveStaff();
		staffMenu(e);
	}
	public void removeRoom(ActionEvent e) throws IOException{
		loadhotelRooms();
		loadGuests();
		Room R = loadRoomDetail();
		for(Person p : Guests) {
			if(p.getRoomNumber()==(R.getRoomNumber())) {
				p.checkOut();
			}
		}
		hotelRooms.remove(R);
		saveRoom();
		saveGuest();
		managementMenu(e);
	}
	public void addStaff(ActionEvent e) throws IOException{
		try {
			loadStaffList();
			PhoneError.setOpacity(0);
			ID_error.setOpacity(0);
			lowWage.setOpacity(0);
			String numStringer;
			if(ID_num.getValue() < 10) {
				numStringer = "00" + ID_num.getValue().toString();
			} else if (ID_num.getValue() < 100) {
				numStringer = "0" + ID_num.getValue().toString();
			} else{
				numStringer = ID_num.getValue().toString();
			}
			numStringer = ID_gender.getValue().toString() + numStringer;
			if(ID_List.contains(numStringer)) {
				throw new IllegalArgumentException("The ID already exists");
			}
			staffList.add(new Staff(numStringer, Name.getText(),Phone.getText(),HourlyWage.getValue()));
			saveStaff();
			staffMenu(e);
		}catch(IllegalArgumentException IAE) {
			if(IAE.getMessage().contains("phone")) {
				PhoneError.setText(IAE.getMessage());
				PhoneError.setOpacity(1);
			}
			else if(IAE.getMessage().contains("ID")){
				ID_error.setText(IAE.getMessage());
				ID_error.setOpacity(1);
			}
			else {
				lowWage.setText(IAE.getMessage());
				lowWage.setOpacity(1);
			}
		}
	}
	private void saveInfo() {
		saveGuest();
		saveRoom();
		saveStaff();
	}
	private void saveGuest() {
		try {
			File f = new File("GuestList.csv");
			FileWriter writer = new FileWriter(f, false);
	        writer.write("");
	        for (Person G : Guests) {
	        	writer.write(GLEncrypt.encrypt(G.getName())  + "," + GLEncrypt.encrypt(G.getPhone())+","+GLEncrypt.encrypt(String.valueOf(G.getRoomNumber()))+","+GLEncrypt.encrypt(String.valueOf(G.getUnpaidCost()))+"\n");
	        }
	        writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void saveGuestDetail(Person G) {
		try {
			File f = new File("GuestDetail.csv");
			FileWriter writer = new FileWriter(f, false);
	        writer.write("");
	        writer.write(GDEncrypt.encrypt(G.getName()) + "," + GDEncrypt.encrypt(G.getPhone())+","+GDEncrypt.encrypt(String.valueOf(G.getRoomNumber()))+","+GDEncrypt.encrypt(String.valueOf(G.getUnpaidCost()))+"\n");
	        writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void saveRoom() {
		try {
			File f = new File("RoomList.csv");
			FileWriter writer = new FileWriter(f, false);
	        writer.write("");
	        for (Room R : hotelRooms) {
	        	if(R.getAvailability()) {
	        		writer.write(RLEncrypt.encrypt(String.valueOf(R.getRoomNumber())) + "," + RLEncrypt.encrypt(R.getType()) + "," + RLEncrypt.encrypt(String.valueOf(R.getCostPerNight())) + "\n");
	        	} else {
	        		writer.write(RLEncrypt.encrypt(String.valueOf(R.getRoomNumber())) + "," + RLEncrypt.encrypt(R.getType()) + "," + RLEncrypt.encrypt(String.valueOf(R.getCostPerNight())) + "," + RLEncrypt.encrypt(R.getGuest().getName()) + "," + RLEncrypt.encrypt(R.getGuest().getPhone()) + "\n");
	        	}
	        }
	        writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void saveRoomDetail(Room R) {
		try {
			File f = new File("RoomDetail.csv");
			FileWriter writer = new FileWriter(f, false);
	        writer.write("");
	        if(R.getAvailability()) {
        		writer.write(RDEncrypt.encrypt(String.valueOf(R.getRoomNumber())) + "," + RDEncrypt.encrypt(R.getType()) + "," + RDEncrypt.encrypt(String.valueOf(R.getCostPerNight())) + "\n");
        	} else {
        		writer.write(RDEncrypt.encrypt(String.valueOf(R.getRoomNumber())) + "," + RDEncrypt.encrypt(R.getType()) + "," + RDEncrypt.encrypt(String.valueOf(R.getCostPerNight())) + "," + RDEncrypt.encrypt(R.getGuest().getName()) + "," + RDEncrypt.encrypt(R.getGuest().getPhone()) + "\n");
        	}
	        writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void saveStaff() {
		try {
			File f = new File("StaffList.csv");
			FileWriter writer = new FileWriter(f, false);
	        writer.write("");
	        for (Staff S : staffList) {
	        	writer.write(SLEncrypt.encrypt(S.getStaffID()) + "," + SLEncrypt.encrypt(S.getName()) + "," + SLEncrypt.encrypt(S.getPhone()) + "," + SLEncrypt.encrypt(String.valueOf(S.getHourlyWage())) +"\n");
	        }
	        writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void saveStaffDetail(Staff S) {
		try {
			File f = new File("StaffDetail.csv");
			FileWriter writer = new FileWriter(f, false);
	        writer.write("");
	        writer.write(SDEncrypt.encrypt(S.getStaffID()) + "," + SDEncrypt.encrypt(S.getName()) + "," + SDEncrypt.encrypt(S.getPhone()) + "," + SDEncrypt.encrypt(String.valueOf(S.getHourlyWage())) +"\n");
	        writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void loadStaffList() {
		// TODO Auto-generated method stub
		try {
			File StaffFile = new File("StaffList.csv");
			Scanner input = new Scanner(StaffFile);
			staffList.clear();
			while (input.hasNextLine()) {
				String aString = input.nextLine();
				String[] parts = aString.split(",");
				Staff s1 = new Staff(SLEncrypt.decrypt(parts[0]), SLEncrypt.decrypt(parts[1]), SLEncrypt.decrypt(parts[2]), Integer.parseInt(SLEncrypt.decrypt(parts[3])));
				staffList.add(s1);
				ID_List.add(parts[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private Staff loadStaffDetail() {
		try {
			File StaffFile = new File("StaffDetail.csv");
			Scanner input = new Scanner(StaffFile);
			String aString = input.nextLine();
			String[] parts = aString.split(",");
			Staff s1 = new Staff(SDEncrypt.decrypt(parts[0]), SDEncrypt.decrypt(parts[1]), SDEncrypt.decrypt(parts[2]), Integer.parseInt(SDEncrypt.decrypt(parts[3])));
			return s1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private void loadGuests() {
		// TODO Auto-generated method stub
		try {
			File guestFile = new File("GuestList.csv");
			Scanner input = new Scanner(guestFile);
			Guests.clear();
			
			while (input.hasNextLine()) {
				String aString = input.nextLine();
				String[] parts = aString.split(",");
//				Person p1 = new Person(parts[0],parts[1],Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
				Person p1 = new Person(GLEncrypt.decrypt(parts[0]), GLEncrypt.decrypt(parts[1]),Integer.parseInt(GLEncrypt.decrypt(parts[2])),Integer.parseInt(GLEncrypt.decrypt(parts[3])));
				Guests.add(p1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private Person loadGuestDetail() {
		try {
			File guestFile = new File("GuestDetail.csv");
			Scanner input = new Scanner(guestFile);
			String aString = input.nextLine();
			String[] parts = aString.split(",");
			Person p1 = new Person(GLEncrypt.decrypt(parts[0]), GLEncrypt.decrypt(parts[1]),Integer.parseInt(GLEncrypt.decrypt(parts[2])),Integer.parseInt(GLEncrypt.decrypt(parts[3])));
			return p1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private Room loadRoomDetail() {
		try {
			File guestFile = new File("RoomDetail.csv");
			Scanner input = new Scanner(guestFile);
			String aString = input.nextLine();
			String[] parts = aString.split(",");
			if(parts.length > 3) {
				Room r1 = new Room(Integer.parseInt(RLEncrypt.decrypt(parts[0])), RLEncrypt.decrypt(parts[1]), Integer.parseInt(RLEncrypt.decrypt(parts[2])), new Person(RLEncrypt.decrypt(parts[3]), RLEncrypt.decrypt(parts[4])));
				return r1;
			} else {
				Room r1 = new Room(Integer.parseInt(RDEncrypt.decrypt(parts[0])), RDEncrypt.decrypt(parts[1]), Integer.parseInt(RDEncrypt.decrypt(parts[2])));
				return r1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private void loadhotelRooms() {
		// TODO Auto-generated method stub
		try {
			hotelRooms.clear();
			File guestFile = new File("RoomList.csv");
			Scanner input = new Scanner(guestFile);
			
			while (input.hasNextLine()) {
				String aString = input.nextLine();
				String[] parts = aString.split(",");
				if(parts.length > 3) {
					Room r1 = new Room(Integer.parseInt(RLEncrypt.decrypt(parts[0])), RLEncrypt.decrypt(parts[1]), Integer.parseInt(RLEncrypt.decrypt(parts[2])), new Person(RLEncrypt.decrypt(parts[3]), RLEncrypt.decrypt(parts[4])));
					hotelRooms.add(r1);
				} else {
					Room r1 = new Room(Integer.parseInt(RLEncrypt.decrypt(parts[0])), RLEncrypt.decrypt(parts[1]), Integer.parseInt(RLEncrypt.decrypt(parts[2])));
					hotelRooms.add(r1);
				}
				RoomNums.add(Integer.parseInt(RLEncrypt.decrypt(parts[0])));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Menu menu = new Menu();
		launch(args);
	}
}
