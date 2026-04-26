package com.contactservice;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	// HashMap that holds all the contacts.
	// The key is the contact ID
	private final Map<String, Contact> contacts = new HashMap<>();
	
	// Adds a new contact to the map.
	// Throws an exception if the contact is null or if a contact with that ID already exists.
	public void addContact(Contact contact) {
		
		if (contact == null) {
			throw new IllegalArgumentException("Sorry, contact cannot be null. Try again.");
		}
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exists. Try again.");
		}
		
		contacts.put(contact.getContactId(), contact);
		
	}
	
	// Removes a contact from the map by its ID.
	// Throws an exception if the ID isn't found.
	public void deleteContact(String contactId) {
		
		if(!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Couldn't find the contact. Try again.");
		}
		
		contacts.remove(contactId);
		
	}
	
	// Updates the first name for the contact with the given ID
	public void updateFirstName(String contactId, String firstName) {
		
		getContactOrThrow(contactId).setFirstName(firstName);
		
	}
	
	// Updates the last name for the contact with the given ID
	public void updateLastName(String contactId, String lastName) {
		
		getContactOrThrow(contactId).setLastName(lastName);
		
	}
	
	// Updates the phone number for the contact with the given ID
	public void updatePhone(String contactId, String phone) {
		
		getContactOrThrow(contactId).setPhone(phone);
		
	}
	
	// Updates the address for the contact with the given ID
	public void updateAddress(String contactId, String address) {
		
		getContactOrThrow(contactId).setAddress(address);
		
	}
	
	// Helper method used by the update methods which looks up the contact and throws
	// an exception if it doesn't exist, so we don't have to repeat that check everywhere
	private Contact getContactOrThrow(String contactId) { 
		
		Contact contact = contacts.get(contactId);
		
		if (contact == null) {
			throw new IllegalArgumentException("Sorry, contact not found. Try again.");
		}
		
		return contact;
	
	}
	
	// Returns the contact with the given ID, or null if it doesn't exist.
	// Used mostly in tests to check whether a contact was added, removed, or updated correctly.
	Contact getContact(String contactId) { return contacts.get(contactId); }

}
