package Hotel;

public class Person {
	private int unpaidCost = 0;
	private final String name;
	private final String phoneNumber;
	private int roomNumber = -1;
	public Person(String name, String phoneNumber) {
		this.name = name;
		if(phoneNumber.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")) {
			this.phoneNumber = phoneNumber;
		}
		else {
			throw new IllegalArgumentException("The phone number is invalid");
		}
	}
	public Person(String name, String phoneNumber, int roomNumber, int unpaidCost) {
		this.name = name;
		if(phoneNumber.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")) {
			this.phoneNumber = phoneNumber;
		}
		else {
			throw new IllegalArgumentException("The phone number is invalid");
		}
		this.roomNumber=roomNumber;
		this.unpaidCost=unpaidCost;
	}
	public void charge(int price) {
		unpaidCost += price;
	}
	public void pay(int amount) {
		if(amount<unpaidCost) {
			unpaidCost -= amount;
		}
		else {
			unpaidCost = 0;
		}
	}

	public int getRoomNumber() {
		return roomNumber;
	}
	
	public void checkIn(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public void checkOut() {
		this.roomNumber = -1;
	}
	
	public String getDetails() {
		return (this.name + " " + this.phoneNumber);
	}
	
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phoneNumber;
	}
	public int getUnpaidCost() {
		return unpaidCost;
	}
	@Override
	public boolean equals(Object o) {
		Person P = (Person) o;
		if(this.name.equals(P.name)&&this.phoneNumber.equals(P.phoneNumber)) {
			return true;
		}
		return false;
	}
}
