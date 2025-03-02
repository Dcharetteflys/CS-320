/*
 * David Charette
 * CS-320
 * 2/12/2025
 */



package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Model.Contact;
import Service.contactService;



class contactServiceTest {

	
	//create test and testing values 
	
	void testContactService() {
		contactService.addContact("Bob", "Dylan", "6618886118", "123 Fake st. Bangor, ME 04401");
		
		//System.out.println(ContactService.contactList.get(0).getId());	used for debugging
		assertTrue(contactService.contactList.get(0).getID().equals("1000000002"));
		assertTrue(contactService.contactList.get(0).getFirstName().equals("Bod"));
		assertTrue(contactService.contactList.get(0).getLastName().equals("Dylan"));
		assertTrue(contactService.contactList.get(0).getPhoneNumber().equals("6618886118"));
		assertTrue(contactService.contactList.get(0).getAddress().equals("123 Fake st. Bangor, ME 04401"));
	}
	
	
	
	//confirm contact removal
	@Test
	void testContactServiceRemove() {
		contactService.addContact("Bob", "Dylan", "6618886118", "123 Fake st. Bangor, ME 04401");
		int size = contactService.contactList.size();
		
		//System.out.println(ContactService.contactList.get(size - 1).getId());
		contactService.removeContact("1000000003");
		
		//ContactService.searchContact("1000000003");
		//System.out.println(ContactService.contactList.get(1).getId());
		assertTrue(contactService.findContact("1000000003") == 2);
	}
	
	// test name update first 
	@Test
	void testContactServiceUpdateFirstName() {
		contactService.addContact("Jack", "Skellingto", "6618886118", "Halloween Ave.");
		int size = contactService.contactList.size();
		System.out.println(contactService.contactList.get(size - 1).getID());
		System.out.println(contactService.contactList.get(size - 1).getFirstName());
		contactService.updateFirstName("1000000003", "Paul");
		System.out.println(contactService.contactList.get(size - 1).getFirstName());
		assertTrue(contactService.contactList.get(size - 1).getFirstName().equals("Paul"));
	}

	
	// will use 2346 for testing the rest
	// testing updating last name 
	@Test
	void testContactServiceUpdateLastName() {
		int size = contactService.contactList.size();
		contactService.updateLastName("1000000003", "Bunyan");
		assertTrue(contactService.contactList.get(size - 1).getLastName().equals("Bunyan"));
	}
	
	
	
	// test updating to number
	@Test
	void testContactServiceUpdatePhone() {
		int target = 0;
		target = contactService.findIndex("1000000003");
		contactService.updateNumber("1000000003", "8884446161");
		assertTrue(contactService.contactList.get(target).getPhoneNumber().equals("8884446161"));
	}
	
	
	
	// test updating to address
	@Test
	void testContactServiceUpdateAddress() {
		int target = 0;
		target = contactService.findIndex("1000000003");
		contactService.updateAddress("1000000003", "123 Fake st. Bangor, ME 04401");
		assertTrue(contactService.contactList.get(target).getAddress().equals("123 Fake st. Bangor, ME 04401"));
	}
	
	
	
	// test to confirm unique ID
	@Test
	void testContactServiceUniqueId() {
		Contact newContact = new Contact("49594", "Teddy", "Smithson", "6618886118", "Original Contact Address");
		contactService.addContact(newContact);
		Contact duplicateId = new Contact("49594", "Teddy", "Smithson", "6618886118", "Duplicate Contact Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(duplicateId);
		});
	}

	
	
	
	

	
	
	
	
}
