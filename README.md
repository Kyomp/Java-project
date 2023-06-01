# Java-project, Hotel Management
On this project, we created an object-oriented hotel management system using Java programming language. The program enables management on a hotel's guests, staff, and room. It has 3 main menus to manage those 3 aspects:
- **Guest** menu features are adding and removing a guest, assigning a guest to a room, and adding service/room charges to the guest. The information displayed for the guests are the name, phone number, current room number, and total fees charges.
- The **staff** menu is able to add and remove staff to the list. The information displayed are name, phone number, staff id, and hourly wage
- The **room** menu is also able to add and remove rooms. The informations are room number, type, cost per night, and the guest name currently staying on a room

The list of guests, staffs, and rooms are stored in an arraylist and txt file. The arraylists serve as the reference of the lists for the methods/algorithm inside the program. It regularly loads data from text file and rewrites it whenever an update is performed, therefore the updates cycle and data is still preserved when program is closed and openned again.

We created a user interface using fxmls files with the help of SceneBuilder software. It enables better interaction with buttons and navigation and better list visualization

The list of libraries used are:
- java.io.File;
- java.io.FileNotFoundException;
- java.io.FileWriter;
- java.io.IOException;
- java.net.URL;
- java.util.ArrayList;
- java.util.List;
- java.util.HashMap;
- java.util.HashSet;
- java.util.Map;
- java.util.ResourceBundle;
- java.util.Scanner;
- java.util.Set;
- javafx.application.Application;
- javafx.event.ActionEvent;
- javafx.event.EventHandler;
- javafx.fxml.FXML;
- javafx.fxml.FXMLLoader;
- javafx.fxml.Initializable;
- javafx.geometry.Pos;
- javafx.scene.Node;
- javafx.scene.Parent;
- javafx.scene.Scene;
- javafx.scene.control.ChoiceBox;
- javafx.scene.control.Spinner;
- javafx.scene.control.SpinnerValueFactory;
- javafx.scene.control.TextField;
- javafx.scene.input.MouseButton;
- javafx.scene.input.MouseEvent;
- javafx.scene.layout.Border;
- javafx.scene.layout.BorderStroke;
- javafx.scene.layout.BorderStrokeStyle;
- javafx.scene.layout.FlowPane;
- javafx.scene.layout.VBox;
- javafx.scene.text.Text;
- javafx.stage.Stage;

# Manual Guide
The user interface have 3 main buttons located in the left side of the interface: "Guest," "Staff," and "Management":

![image](https://github.com/Kyomp/Java-project/assets/91313923/d01f7533-7d96-4356-933e-c6acb0ebd540)

If those buttons are clicked it will show each aspect's lists (it will navigate to another window that has a list display that is shown in form of a box):

![image](https://github.com/Kyomp/Java-project/assets/91313923/eccc3ee8-2c55-4a77-9884-7473eb93167d)
![image](https://github.com/Kyomp/Java-project/assets/91313923/4bc6f4aa-0396-4a72-9f13-b2b0a377abde)
![image](https://github.com/Kyomp/Java-project/assets/91313923/3af36143-a05e-40a3-b4a0-fcb156192f66)

Each of them has an "add" button that will navigate to each aspect's add window to append the list with new data object.

the add guest menu has 2 field that can be filled in. You can fill a name and a phone number. The accepted phone number are home and mobile that either contains a '+' in front or not. A phone number with wrong format will produce an error message shown in the red text below.

![image](https://github.com/Kyomp/Java-project/assets/91313923/e8a2e873-e419-40dd-bb4d-796fad18f87f)
![image](https://github.com/Kyomp/Java-project/assets/91313923/78e27697-5b67-4391-b43e-ae0337bb90a9)

The add staff menu has 4 fields to be filled/modified: Name, Phone Number, Staff ID, and Hourly Wage. Phone number format is the same as before. Staff ID consist of a choice box for "M" for male and "F" for female and a number field (max 3 digit). If an ID already exist, an error message is shown. Hourly wage has a minimum of 2000 and below that will show an error message.

![image](https://github.com/Kyomp/Java-project/assets/91313923/865fd0d0-1cba-4560-a15b-70aaa877b1c5)
![image](https://github.com/Kyomp/Java-project/assets/91313923/104bc75e-1863-49f9-a7ac-adb4af5508aa)
![image](https://github.com/Kyomp/Java-project/assets/91313923/4cc03247-568a-4a56-afd9-8d98058c3282)

The add room menu has 3 fields: Room Number, Type, and Cost per Night. If the room number is filled with a number that is taken by existing room, an error message will be shown

![image](https://github.com/Kyomp/Java-project/assets/91313923/5996883b-3576-4b46-93e5-4d1c11c20853)
![image](https://github.com/Kyomp/Java-project/assets/91313923/3afba128-5b57-4e80-88b7-034be518b5c5)

