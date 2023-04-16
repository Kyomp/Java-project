package Hotel;

public class Room {
	private boolean availability;
	private boolean clean_status;
	private String type;
	private Fridge fridge;
	private Person guest;
	
	public Room(String type, Fridge fridge) {
		availability = true;
		clean_status = true;
		this.type = type;
		this.fridge = fridge;
		guest = null;
	}
	
	public void checkIn(Person guest) {
		availability = false;
		this.guest = guest;
	}
	public void checkOut() {
		availability = true;
		this.guest = null;
	}
}
