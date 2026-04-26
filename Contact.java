package com.contactservice;

//This class represents a contact. Each contact has an ID, first name, last name,
//phone number, and address. All fields are validated when the contact is created or updated.
public class Contact {
	
	// The contact ID to be set once and can't be changed
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor that builds the contact and validates all the fields
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		
		// ID can't be null and has to be 10 characters or less
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID entered.");
		}
		
		this.contactId = contactId;
		
		// Using the setters here so we don't have to repeat the validation logic
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
		
	}
	
	// Returns the specified data
	public String getContactId() { return contactId; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getPhone() { return phone; }
	public String getAddress() { return address; }
	
	// Updates the first name which can't be null and has to be 10 characters or less
	public void setFirstName(String firstName) {
		
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name entered.");
		}
		
		this.firstName = firstName;
		
	}
	
	// Updates the last name which can't be null and has to be 10 characters or less
	public void setLastName(String lastName) {
		
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name entered.");
		}
		
		this.lastName = lastName;
		
	}
	
	// Updates the phone number which must be exactly 10 digits, no letters or symbols
	public void setPhone(String phone) {
		
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid phone number entered.");
		}
		
		this.phone = phone;
		
	}
	
	// Updates the address which can't be null and has to be 30 characters or less
	public void setAddress(String address) {
		
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address entered.");
		}
		
		this.address = address;
		
	}
	
}
