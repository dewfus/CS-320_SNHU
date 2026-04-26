package com.contactservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

	private ContactService service;
	private Contact sampleContact;
	
	// Runs before each test to give us a fresh service and a sample contact to work with
	@BeforeEach
	void setUp() {
		
		service = new ContactService();
		sampleContact = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
		
	}
	
	// Makes sure a valid contact can be added and retrieved
	@Test
	void testAddContactSuccess() {
		
		service.addContact(sampleContact);
        assertNotNull(service.getContact("ID01"));
        
	}
	
	// Makes sure adding two contacts with the same ID throws an exception
	@Test
	void testAddDuplicateContactThrows() {
		
		service.addContact(sampleContact);
        Contact duplicate = new Contact("ID01", "Jane", "Smith", "0987654321", "456 Elm St");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
		
	}
	
	// Makes sure adding a null contact throws an exception
	@Test
	void testAddNullContactThrows() {
		
		assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
		
	}
	
	// Makes sure a contact is actually removed after being deleted
	@Test
	void testDeleteContactSuccess() {
		
		service.addContact(sampleContact);
        service.deleteContact("ID01");
        assertNull(service.getContact("ID01"));
		
	}
	
	// Makes sure trying to delete a contact that doesn't exist throws an exception
	@Test
	void testDeleteNonExistentContactThrows() {
		
		assertThrows(IllegalArgumentException.class, () -> service.deleteContact("NONE"));
		
	}
	
	// Makes sure the first name can be updated through the service
	@Test
	void testUpdateFirstNameSuccess() {
		
		service.addContact(sampleContact);
        service.updateFirstName("ID01", "Jane");
        assertEquals("Jane", service.getContact("ID01").getFirstName());
		
	}
	
	// Makes sure updating the first name for a contact that doesn't exist throws an exception
	@Test
	void testUpdateFirstNameNotFound() {
		
		assertThrows(IllegalArgumentException.class, () ->
        	service.updateFirstName("NONE", "Jane"));
		
	}
	
	// Makes sure the last name can be updated through the service
	@Test
	void testUpdateLastNameSuccess() {
		
		service.addContact(sampleContact);
        service.updateLastName("ID01", "Smith");
        assertEquals("Smith", service.getContact("ID01").getLastName());
		
	}
	
	// Makes sure updating the last name for a contact that doesn't exist throws an exception
	@Test
	void testUpdateLastNameNotFound() {
		
		assertThrows(IllegalArgumentException.class, () ->
        	service.updateLastName("NONE", "Smith"));
		
	}
	
	// Makes sure the phone number can be updated through the service
	@Test
	void testUpdatePhoneSuccess() {
		
		service.addContact(sampleContact);
        service.updatePhone("ID01", "0987654321");
        assertEquals("0987654321", service.getContact("ID01").getPhone());
		
	}
	
	// Makes sure an invalid phone number throws an exception when updating
	@Test
	void testUpdatePhoneInvalidFormat() {
		
		service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updatePhone("ID01", "123"));
		
	}
	
	// Makes sure the address can be updated through the service
	@Test
	void testUpdateAddressSuccess() {
		
		service.addContact(sampleContact);
        service.updateAddress("ID01", "456 Elm St");
        assertEquals("456 Elm St", service.getContact("ID01").getAddress());
		
	}
	
	// Makes sure an address that's too long throws an exception when updating
	@Test
	void testUpdateAddressTooLong() {
		
		service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updateAddress("ID01", "This address is way too long for the field"));
		
	}
	
}
