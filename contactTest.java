/*
 * David Charette
 * 
 *CS-320
 *2/12/2025
 */

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Model.Contact;



class contactTest {
		@Test
		void testContactClass() {
			Contact newContact = new Contact("2345", "Bob", "Dylan", "6618886118", "123 Fake st. Bangor, ME 04401");
			assertTrue(newContact.getFirstName().equals("Bob"));
			assertTrue(newContact.getLastName().equals("Dylan"));
			assertTrue(newContact.getID().equals("2345"));
			assertTrue(newContact.getPhoneNumber().equals("6618886118"));
			assertTrue(newContact.getAddress().equals("123 Fake st. Bangor, ME 04401"));
		}
		
		// test for too long ID
		@Test
		void testContactClassIDTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("10000000000", "Bob", "Dylan", "6618886118", 
					"123 Fake st. Bangor, ME 04401");
			});
		}
		
		// test for Null ID
		@Test
		void testContactClassIDNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact(null, "Bob", "Dylan", "6618886118", 
					"123 Fake st. Bangor, ME 04401");
			});
		
		}
		
		// test for long first name
		@Test
		void testContactClassFirstNameLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("2345", "Bob12345678", "Dylan", "6618886118", 
					"123 Fake st. Bangor, ME 04401");
			});
		
		}
		
		// test first name null
		@Test
		void testContactClassFirstNameNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("2345", null, "Dylan", "6618886118", 
					"123 Fake st. Bangor, ME 04401");
			});
		
		}
		
		// last name to long
		@Test
		void testContactClassLastNameLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("2345", "Bob", "Dylan123456", "6618886118", 
					"123 Fake st. Bangor, ME 04401");
			});
		
		}
		
		//test last name null
		@Test
		void testContactClassLastNameNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("2345", "Bob", null, "6618886118", 
					"123 Fake st. Bangor, ME 04401");
			});
		
		}
		
		//test number not 10 long
		@Test
		void testContactClassNumberLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("2345", "Bob", "Dylan", "6618886118123", 
					"123 Fake st. Bangor, ME 04401");
			});
		
		}
		// second test for number not 10 long
		@Test
		void testContactClassNumberShort() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("2345", "Bob", "Dylan", "66188861", 
					"123 Fake st. Bangor, ME 04401");
			});
		
		}
		//test number for null
		@Test
		void testContactClassNumbernull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("2345", "Bob", "Dylan", null, 
					"123 Fake st. Bangor, ME 04401");
			});
		
		}
		
		//test address to long 
		@Test
		void testContactClassAddressLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("2345", "Bob", "Dylan", "6618886118", 
					"123 this is wat to long for the specs st. Bangor, ME 04401");
			});
		
		}
		
		@Test
		void testContactClassAddressNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("2345", "Bob", "Dylan", "6618886118", 
					null);
			});
		
		}
		
		
		
		
		// test f_Name setter 
		@Test
		void testContactClassSetFirstName() {
			Contact newContact = new Contact("324", "Rob", "BoB", "1018675309", "New address 1");
			newContact.setFirstName("Bobby");
			assertTrue(newContact.getFirstName().equals("Bobby"));
		}
		@Test
		void testContactClassSetFirstNameLong() {
			Contact newContact = new Contact("324", "Rob", "BoB", "1018675309", "New address 1");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				newContact.setFirstName("BobbyToLong");
			});
		}
		@Test
		void testContactClassSetFirstNameNull() {
			Contact newContact = new Contact("324", "Rob", "BoB", "1018675309", "New address 1");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				newContact.setFirstName(null);
			});
		}
		
		
		
		// test l_Name setter 
		@Test
		void testContactClassSetLastName() {
			Contact newContact = new Contact("324", "Rob", "BoB", "1018675309", "New address 1");
			newContact.setLastName("Bobby");
			assertTrue(newContact.getLastName().equals("Bobby"));
		}
		@Test
		void testContactClassSetLastNameTooLong() {
			Contact newContact = new Contact("324", "Rob", "BoB", "1018675309", "New address 1");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				newContact.setLastName("BobbyTooLong");
			});
		}
		@Test
		void testContactClassSetLastNameNull() {
			Contact newContact = new Contact("324", "Rob", "BoB", "1018675309", "New address 1");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				newContact.setLastName(null);
			});
		}
		
		
		
		
		// test number setter 
		@Test
		void testContactClassSetNumber() {
			Contact newContact = new Contact("324", "Rob", "BoB", "1018675309", "New address 1");
			newContact.setNumber("1018675309");
			assertTrue(newContact.getPhoneNumber().equals("1018675309"));
		}
		@Test
		void testContactClassSetNumberLong() {
			Contact newContact = new Contact("324", "Rob", "BoB", "1018675309", "New address 1");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				newContact.setNumber("101867530999999");
			});
		}
		@Test
		void testContactClassSetNumberNull() {
			Contact newContact = new Contact("324", "Rob", "BoB", "1018675309", "New address 1");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				newContact.setNumber(null);
			});
		}
		@Test
		void testContactClassSetNumberShort() {
			Contact newContact = new Contact("324", "Rob", "BoB", "1018675309", "New address 1");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				newContact.setNumber("44444");
			});
		}
		
		
		
		
		// test address setter 
		@Test
		void testContactClassSetAddress() {
			Contact newContact = new Contact("324", "Rob", "BoB", "1018675309", "New address 1");
			newContact.setAddress("new address 2");
			assertTrue(newContact.getAddress().equals("new address 2"));
		}
		@Test
		void testContactClassSetAddressTooLong() {
			Contact newContact = new Contact("324", "Rob", "BoB", "1018675309", "New address 1");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				newContact.setAddress("new address too long 1324566874685");
			});
		}
		@Test
		void testContactClassSetAddressNull() {
			Contact newContact = new Contact("324", "Rob", "BoB", "1018675309", "New address 1");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				newContact.setAddress(null);
			});
		}
	
	}

