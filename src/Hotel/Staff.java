package Hotel;

public class Staff {
	private final String staffID;
	private final String staffName;
	private Room work_room;
	
	public Staff(String staffID, String staffName) {
		if(staffID.matches("^(F|M).*\\[0-9]{3}$")) {
			this.staffID = staffID;
		} else {
			throw new IllegalArgumentException("The ID input has incorrect format");
		}
		this.staffName = staffName;
		this.work_room = null;
	}
	
	public Staff(String staffID, String staffName, Room work_room) {
		if(staffID.matches("^(F|M).*\\[0-9]{3}$")) {
			this.staffID = staffID;
		} else {
			throw new IllegalArgumentException("The ID input has incorrect format");
		}
		this.staffName = staffName;
		this.work_room = work_room;
	}
	
	public void assignRoom(Room room) {
		this.work_room = room;
	}
	
	public void deassignRoom() {
		this.work_room = null;
	}
}
