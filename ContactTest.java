package com.contactservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

	// Makes sure a valid contact can be created and all fields are stored correctly
	@Test
	void testContactCreatedSuccessfully() {
		
		Contact c = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
		
		assertEquals("ID01", c.getContactId());
		assertEquals("John", c.getFirstName());
		assertEquals("Doe", c.getLastName());
		assertEquals("1234567890", c.getPhone());
		assertEquals("123 Main St", c.getAddress());
		
	}
	
	// Makes sure an ID that's too long throws an exception
	@Test
	void testContactIdTooLong() {
		assertThrows(IllegalArgumentException.class, () ->
			new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
	}
	
	// Makes sure a null ID throws an exception
	@Test
	void testContactIdNull() {
		assertThrows(IllegalArgumentException.class, () ->
			new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
	}
	
	// Makes sure a first name that's too long throws an exception
	@Test
	void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () ->
			new Contact("ID01", "JohnnyBGoode", "Doe", "1234567890", "123 Main St"));
	}
	
	// Makes sure a null first name throws an exception
	@Test
	void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () ->
			new Contact("ID01", null, "Doe", "1234567890", "123 Main St"));
	}
	
	// Makes sure a last name that's too long throws an exception
	@Test
	void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () ->
			new Contact("ID01", "John", "DoeReyMiFaSoLaTeeDoh", "1234567890", "123 Main St"));
	}
	
	// Makes sure a null last name throws an exception
	@Test
	void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, () ->
			new Contact("ID01", "John", null, "1234567890", "123 Main St"));
	}
	
	// Makes sure a phone number that's too short throws an exception
	@Test
	void testPhoneNumberTooShort() {
		assertThrows(IllegalArgumentException.class, () ->
		new Contact("ID01", "John", "Doe", "1123", "123 Main St"));
	}
	
	// Makes sure a phone number that's too long throws an exception
	@Test
	void testPhoneNumberTooLong() {
		assertThrows(IllegalArgumentException.class, () ->
		new Contact("ID01", "John", "Doe", "112345678900", "123 Main St"));
	}
	
	// Makes sure a phone number with letters throws an exception
	@Test
	void testPhoneContainsLetters() {
		assertThrows(IllegalArgumentException.class, () ->
		new Contact("ID01", "John", "Doe", "123456789A", "123 Main St"));
	}
	
	// Makes sure a null phone number throws an exception
	@Test
	void testPhoneNull() {
		assertThrows(IllegalArgumentException.class, () ->
			new Contact("ID01", "John", "Doe", null, "123 Main St"));
	}
	
	// Makes sure an address that's too long throws an exception
	@Test
	void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () ->
			new Contact("ID01", "John", "Doe", "1234567890", "longaddressnamebutmaybetoolongidontreallyknow"));
	}
	
	// Makes sure a null address throws an exception
	@Test
	void testAddressNull() {
		assertThrows(IllegalArgumentException.class, () ->
			new Contact("ID01", "John", "Doe", "1234567890", null));
	}
	
	// Makes sure the first name can be updated to a valid value
	@Test
	void testSetFirstNameValid() {
		Contact c = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
		c.setFirstName("Jane");;
		assertEquals("Jane", c.getFirstName());
	}
	
	// Makes sure the first name setter rejects a null value
	@Test
	void testSetFirstNameInvalid() {
		Contact c = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));
	}
	
	// Makes sure the last name can be updated to a valid value
	@Test
	void testSetLastNameValid() {
		Contact c = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
		c.setLastName("Smith");
		assertEquals("Smith", c.getLastName());
	}
	
	// Makes sure the last name setter rejects a null value
	@Test
	void testSetLastNameInvalid() {
		Contact c = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, () -> c.setLastName(null));
	}
	
	// Makes sure the phone number can be updated to a valid value
	@Test
	void testSetPhoneValid() {
		Contact c = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
		c.setPhone("0987654321");
        assertEquals("0987654321", c.getPhone());
	}
	
	// Makes sure the address can be updated to a valid value
	@Test
	void testSetAddressValid() {
		Contact c = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
		c.setAddress("456 Elm St");
        assertEquals("456 Elm St", c.getAddress());
	}
	
}
