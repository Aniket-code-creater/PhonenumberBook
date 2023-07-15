package com.contact.Services;

import java.lang.reflect.Method;
import java.util.List;

import com.contact.Entity.Contact;
import com.contact.Exceptions.ContactNotFoundException;
import com.contact.Exceptions.NameNotFoundException;
import com.contact.Exceptions.NumberNotFoundException;

public interface ContactService {
	
	//Method for Add Contact Number
	public Contact addContact(Contact contact);
	
	//Method for Find Contact by contact Id 
	public Contact findContactbyid(Integer id) throws ContactNotFoundException;
	
	
	//Method For find contact by contact Name
	public List<Contact> findbyName(String name) throws NameNotFoundException;
	
	//Method for find contact by contact Number
	public List<Contact> findbyNumbers(String phoneNumber)throws NumberFormatException;
	
	
	//MEthod for find All contact list
	public List<Contact> findAllContact() throws ContactNotFoundException;
	
	
	//MEthod for update Existing Contact Details
	public Contact updateContactdetails(Contact contact) throws ContactNotFoundException;
	
	
	//Method for Add  One More Contact Number in Existing Contact 
	public Contact addPhoneNumber(String phoneNumber, Integer id) throws ContactNotFoundException;
	
	
	//MEthod for Delete on contact number in existing Contact by contact number and id
	public Contact deletePhoneNumber(String phoneNumber, Integer id) throws NumberNotFoundException;
	
	//Method for delete contact by contact id
	public Contact deleteContact(Integer id) throws ContactNotFoundException;
	

}
