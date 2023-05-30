package Hotel;

import java.util.HashSet;
import java.util.Set;

public class Staff {
	private final String staffID;
	private final String staffName;
	private final String phoneNumber;
	private final int hourlyWage;
//	public static Set<String> ID_List = new HashSet<String>();
	
	public Staff(String staffID, String staffName, String phoneNumber, int hourlyWage) {
		
		if(!staffID.matches("(F|M).*[0-9]{3}$")) {
			throw new IllegalArgumentException("The ID input has incorrect format");
//		} else if(Staff.ID_List.contains(staffID)) {
//			throw new IllegalArgumentException("The ID already exists");
		}else {
			this.staffID = staffID;
		}
		if(phoneNumber.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")) {
			this.phoneNumber = phoneNumber;
		}
		else {
			throw new IllegalArgumentException("The phone number is invalid");
		}
		if(hourlyWage<20000) {
			throw new IllegalArgumentException("OI! Do you have no ethics?!!!");
		}
		else {
			this.hourlyWage = hourlyWage;
		}
		this.staffName = staffName;
//		Staff.ID_List.add(staffID);
	}
	public String getDetails() {
		return this.staffID + " " + this.staffName + " " + this.phoneNumber;
	}
	public String getStaffID() {
		return staffID;
	}
	public String getName() {
		return staffName;
	}
	public String getPhone() {
		return phoneNumber;
	}
	
	@Override
	public boolean equals(Object object) {
		Staff s = (Staff)object;
		if(this.staffID.equals(s.staffID)) {
			return true;
		}
		return false;
	}
	public int getHourlyWage() {
		return hourlyWage;
	}
}
