
/**********
 * David Charette
 * CS-320
 * 2/12/2025
 * This is the class for contact service. This will maintain the list of contacts information and allow for changes
 */




package Service;

import java.util.ArrayList;

import Model.Contact;

public class contactService {
	
	// Variables 
	
	public static String publicID;
	public String publicFirstname;
	public String publicLastName;
	public String publicPhoneNumber;
	public String publicAddress;
	

	// create array list to hold the contact information
	
	public static ArrayList<Contact> contactList = new ArrayList<Contact>(0);
	
	
	// create unique id
	
	public static String generateUniqueID() {
		//holder
		String uniqueID;
		
		//starting with a 10 digit number if list is empty 
		if (contactList.isEmpty()) {
			publicID = "1000000001";
		}
		
		//gets the last value
		else {
			int arraySize = contactList.size();
			publicID = contactList.get(arraySize - 1).getID();
		}
		
		//convert string to integer for next value
		int tempInt = Integer.valueOf(publicID);
		
		// increment next value
		tempInt +=1;
		
		//convert to string
		uniqueID = Integer.toString(tempInt);
		return uniqueID;	
	}
	
	// create contact and add to array
	public static void addContact(String f_Name, String l_Name, String newPhoneNumber, String newAddress) {
		String ID = generateUniqueID();
		Contact Contact1 = new Contact(ID, f_Name, l_Name, newPhoneNumber, newAddress);
		contactList.add(Contact1);
	}
	
	//add contact for manual testing
	
	public static void addContact(Contact newContact) {
		String tempID = newContact.getID();
		for (int i = 0; i < contactList.size(); i++) {
			if (tempID.equals(contactList.get(i).getID())) {
				throw new IllegalArgumentException("Contact ID Must Be Unique");
			}
		}
		contactList.add(newContact);
	}
	
	// method for updating fields 
	
	public static void updateFirstName(String uniqueID, String publicFirstName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueID.compareTo(contactList.get(i).getID()) == 0) {
			contactList.get(i).setFirstName(publicFirstName);
			}
		}
	}
	
	public static void updateLastName(String uniqueID, String publicLastName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueID.compareTo(contactList.get(i).getID()) == 0) {
			contactList.get(i).setLastName(publicLastName);
			}
		}
	}
	
	public static void updateNumber(String uniqueID, String publicPhoneNumber) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueID.compareTo(contactList.get(i).getID()) == 0) {
			contactList.get(i).setNumber(publicPhoneNumber);
			}
		}
	}
	
	public static void updateAddress(String uniqueID, String publicAddress) {
		for (int i = 0; i < contactList.size(); i++) {
			if (uniqueID.compareTo(contactList.get(i).getID()) == 0) {
			contactList.get(i).setAddress(publicAddress);
			}
		}
	}
	
	
	// removed contact
	
	public static void removeContact(String uniqueID) {
		for(int i = 0; i < contactList.size(); i++) {
			if(uniqueID.compareTo(contactList.get(i).getID()) == 0) {
				int position = i;
				//removed from array
				contactList.remove(position);
			}
		}
	}
	
	
	// search function
	public static int findContact(String uniqueID) {
		int result = 0;
		for(int i = 0; i < contactList.size(); i++) {
			if(uniqueID.compareTo(contactList.get(i).getID()) == 0) {
				result = 1;
			}
			else {
				result = 2;
			}
		}
		return result;
	}
	
	//find index
	public static int findIndex(String uniqueID) {
		int result = 0;
		for (int i = 0; i < contactList.size(); i++) {
			if(uniqueID.compareTo(contactList.get(i).getID()) == 0){
				result = i;
			}
		}
		return result;
	}
	
	
}
