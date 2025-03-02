/**************
 * David Charette
 * CS-320
 * 2/12/25
 * This class is the contact class, this is going to create and store contact info
 */



package Model;


public class Contact {
	
	// Variables needed for this class
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address ) {
		
		// check this requirements for variables
		
		if(contactID == null || contactID.length() > 10 ) {
			throw new IllegalArgumentException("Invaild ID");
		}
		
		if(firstName == null || firstName.length() > 10 ) {
			throw new IllegalArgumentException("Ivalvid First Name");
		}
		
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		if(phoneNumber == null || phoneNumber.length() != 10 ) {
			throw new IllegalArgumentException("invalid Number");
		}
		
		if(address == null || address.length() > 30 ) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		// to handle if there are no exceptions
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		
	}

	//getters 
	
	public String getID() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress(){
		return address;
	}
	
	
	// setters 
	// There is no setter for contactID as it should not be updated 
	
	public void setFirstName(String f_Name) {
		if(f_Name == null || f_Name.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = f_Name;
	}
	
	
	public void setLastName(String l_Name) {
		if(l_Name == null || l_Name.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = l_Name;
	}
	
	public void setNumber(String newPhoneNumber) {
		if(newPhoneNumber == null || newPhoneNumber.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		this.phoneNumber = newPhoneNumber;
	}
	
	
	public void setAddress(String newAddress) {
		if(newAddress == null || newAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = newAddress;
		
	}
	
	
	
}










