# Java-project, Hotel Management
On this project, we created an object-oriented hotel management system using Java programming language. The program enables management on a hotel's guests, staff, and room. It has 3 main menus to manage those 3 aspects:
- **Guest** menu features are adding and removing a guest, assigning a guest to a room, and adding service/room charges to the guest. The information displayed for the guests are the name, phone number, current room number, and total fees charges.
- The **staff** menu is able to add and remove staff to the list. The information displayed are name, phone number, staff id, and hourly wage
- The **room** menu is also able to add and remove rooms. The informations are room number, type, cost per night, and the guest name currently staying on a room

The list of guests, staffs, and rooms are stored in an arraylist and txt file. The arraylists serve as the reference of the lists for the methods/algorithm inside the program. It regularly loads data from text file and rewrites it whenever an update is performed, therefore the updates cycle and data is still preserved when program is closed and openned again.

We created a user interface using fxmls files with the help of SceneBuilder software. It enables better interaction with buttons and navigation and better list visualization

# The list of libraries
- java.io.File
- java.io.FileNotFoundException
- java.io.FileWriter
- java.io.IOException
- java.net.URL
- java.util.ArrayList
- java.util.List
- java.util.HashMap
- java.util.HashSet
- java.util.Map
- java.util.ResourceBundle
- java.util.Scanner
- java.util.Set
- javafx.application.Application
- javafx.event.ActionEvent
- javafx.event.EventHandler
- javafx.fxml.FXML
- javafx.fxml.FXMLLoader
- javafx.fxml.Initializable
- javafx.geometry.Pos
- javafx.scene.Node
- javafx.scene.Parent
- javafx.scene.Scene
- javafx.scene.control.ChoiceBox
- javafx.scene.control.Spinner
- javafx.scene.control.SpinnerValueFactory
- javafx.scene.control.TextField
- javafx.scene.input.MouseButton
- javafx.scene.input.MouseEvent
- javafx.scene.layout.Border
- javafx.scene.layout.BorderStroke
- javafx.scene.layout.BorderStrokeStyle
- javafx.scene.layout.FlowPane
- javafx.scene.layout.VBox
- javafx.scene.text.Text
- javafx.stage.Stage

# Features
**Guests**
- View list of guests
- View details of a selected guest
- Adding new guests
- Removing existing guests
- Assigning guests to a room
- Check out guests from their room
- Charging services fee to guests

**Staffs**
- View list of staffs
- View details of a selected staff
- Adding new staffs
- Removing existing staffs

**Rooms**
- View list of rooms
- View details of selected rooms
- Adding new rooms
- Removing existing rooms

# Manual Guide
The user interface have 3 main buttons located in the left side of the interface: "Guest," "Staff," and "Management":

![image](https://github.com/Kyomp/Java-project/assets/91313923/64da97b8-de0e-4411-bb5c-a8396d50ba7b)

If those buttons are clicked it will show each aspect's lists of objects (it will navigate to another window that has a list display that is shown in form of a box):

![image](https://github.com/Kyomp/Java-project/assets/91313923/d86b0329-fe1b-40c5-82e2-ad2a71f8c685)
![image](https://github.com/Kyomp/Java-project/assets/91313923/dc02cf27-04a4-467d-85d2-b682c9342301)
![image](https://github.com/Kyomp/Java-project/assets/91313923/22f1d858-dd1f-452e-b965-5c82327cb27d)

Each of them has an "add" button that will navigate to each aspect's add window to append the list with new data object.

the add guest menu has 2 field that can be filled in. You can fill a name and a phone number. The accepted phone number are home and mobile that either contains a '+' in front or not. A phone number with wrong format will produce an error message shown in the red text below.

![image](https://github.com/Kyomp/Java-project/assets/91313923/ac4cee34-f848-4d3d-bfc7-eaa37ca3d996)
![image](https://github.com/Kyomp/Java-project/assets/91313923/898059fb-2147-45bf-9a1e-e6c7bbbb11a5)

The add staff menu has 4 fields to be filled/modified: Name, Phone Number, Staff ID, and Hourly Wage. Phone number format is the same as before. Staff ID consist of a choice box for "M" for male and "F" for female and a number field (max 3 digit). If an ID already exist, an error message is shown. Hourly wage has a minimum of 2000 and below that will show an error message.

![image](https://github.com/Kyomp/Java-project/assets/91313923/f813c7e9-8d6d-4733-950f-1cab3028e145)
![image](https://github.com/Kyomp/Java-project/assets/91313923/12630dc7-bd25-4500-b8b3-62e075dc8473)
![image](https://github.com/Kyomp/Java-project/assets/91313923/c48a58e5-c750-4bf8-a6ba-06785138b72c)

The add room menu has 3 fields: Room Number, Type, and Cost per Night. If the room number is filled with a number that is taken by existing room, an error message will be shown

![image](https://github.com/Kyomp/Java-project/assets/91313923/d829fcae-6a15-4153-bb60-957682865b16)
![image](https://github.com/Kyomp/Java-project/assets/91313923/71f2d305-9775-40b0-be6e-d06c7b8080c5)

On each lists, if the box is double-clicked, it will navigate to the details window that shows the detail of selected object.

![image](https://github.com/Kyomp/Java-project/assets/91313923/ac95b4a1-27a2-4969-8b71-c3005bb6ef11)
![image](https://github.com/Kyomp/Java-project/assets/91313923/cabe0ba9-4296-45cf-8521-f0fe3517c293)
![image](https://github.com/Kyomp/Java-project/assets/91313923/ec9e2820-619e-4ead-8ab0-b60bb34ae5f7)

The Guest details shows the name, phone number, room nunber, and remaining charge. It also has four buttons: assign room, charge, check out, and remove.

Assign room button will navigate to assign room window that enable user to input a room nunber for the guest to stay. If a room input is already occupied or the room does not exist, it will show an error message.

![image](https://github.com/Kyomp/Java-project/assets/91313923/2fa6bdb5-b9ab-4f5b-8b48-6662a1347ae0)
![image](https://github.com/Kyomp/Java-project/assets/91313923/b274298d-6aec-4ae2-9a45-d081f09c5c33)
![image](https://github.com/Kyomp/Java-project/assets/91313923/3cf201ff-3562-41b1-9a3d-bce6a50173d7)

Charge button will lead into a charge guest menu that displays the guest name and remaining charge amount, a choice box is also present to choose which service to charge that sets the room as the charge choice for the guest. If a guest is not staying in a room and they are charged with room fee, an error message will show. Charge button is to add charge amount to the guest, and the ok button is to go back to the guest list.

![image](https://github.com/Kyomp/Java-project/assets/91313923/51b40301-1482-4bba-ac75-b67ef5cbac55)
![image](https://github.com/Kyomp/Java-project/assets/91313923/d3de7ace-f38a-406a-ae11-a79ff6e880fe)

Check out button will remove room number from the selected guest and directly go back to guest list. Same also goes to remove button, that will delete the selected guest and go back to the list page.

Now, in the staff detail window, it will show the staff name, phone number, staff ID, and hourly wage. It also has remove button to delete the selected staff

![image](https://github.com/Kyomp/Java-project/assets/91313923/149bbcf1-dad3-40a9-ab48-9c07c7674980)

In the room detail window, the room number, type, cost per night and the current guest's name. A remove button is also present to delete a room from the program.

![image](https://github.com/Kyomp/Java-project/assets/91313923/24ba849e-92ec-4970-8752-b14c762d1d0a)
