package Hotel;

public class Staff {
	private final String staffID;
	private final String staffName;
	private final String phoneNumber;
	private Room work_room;
	
	public Staff(String staffID, String staffName, String phoneNumber) {
		
		if(staffID.matches("(F|M).*[0-9]{3}$")) {
			this.staffID = staffID;
		} else {
			throw new IllegalArgumentException("The ID input has incorrect format");
		}
		if(phoneNumber.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")) {
			this.phoneNumber = phoneNumber;
		}
		else {
			throw new IllegalArgumentException("The phone number is invalid");
		}
		this.staffName = staffName;
		this.work_room = null;
	}
	
	public Staff(String staffID, String staffName, Room work_room, String phoneNumber) {
		if(staffID.matches("^(F|M).*\\[0-9]{3}$")) {
			this.staffID = staffID;
		} else {
			throw new IllegalArgumentException("The ID input has incorrect format");
		}
		if(phoneNumber.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")) {
			this.phoneNumber = phoneNumber;
		}
		else {
			throw new IllegalArgumentException("The phone number is invalid");
		}
		this.staffName = staffName;
		this.work_room = work_room;
	}
	
	public void assignRoom(Room room) {
		this.work_room = room;
		
	}
	
	public void unassignRoom() {
		this.work_room = null;
	}
	
	public String getDetails() {
		return this.staffID + " " + this.staffName + " " + this.phoneNumber;
	}
}
