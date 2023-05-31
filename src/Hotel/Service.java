package Hotel;

import java.util.HashMap;

public class Service {
	public static HashMap<String, Integer> getServiceList() {
        HashMap<String, Integer> serviceList = new HashMap<String, Integer>();
        serviceList.put("None", 0);
        serviceList.put("Room Spa", 100000);
        serviceList.put("Hot Bath Access", 50000);
        serviceList.put("Laundry", 80000);
        serviceList.put("Airport Shuttle", 200000);
        serviceList.put("Champagne", 110000);
        serviceList.put("Mineral Water", 10000);
        serviceList.put("French Fries", 45000);
        serviceList.put("Chicken Wings", 40000);
        return serviceList;
    }

}
