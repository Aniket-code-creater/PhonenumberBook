package com.contact.Services.ServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.Entity.Contact;
import com.contact.Exceptions.ContactNotFoundException;
import com.contact.Exceptions.NameNotFoundException;
import com.contact.Exceptions.NumberNotFoundException;
import com.contact.Repository.ContactRepository;
import com.contact.Services.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact addContact(Contact contact) {
		// TODO Auto-generated method stub
		// Add a new contact to the database
		Contact c1=contactRepository.save(contact);
		return c1;
	}

	@Override
	public List<Contact> findbyName(String name) throws NameNotFoundException {
		// TODO Auto-generated method stub
		// Find contacts by name
		List<Contact> contactlist= contactRepository.findByfirstName(name);
		
		//Check contact is Empty or not
		if(contactlist.isEmpty()) {
			
			//throw error message if contact is empty
			throw new NameNotFoundException("Contact numbers Not fond with Name "+name);
		}else {
			return contactlist;
		}
		
	}

	@Override
	public List<Contact> findbyNumbers(String phoneNumber) throws NameNotFoundException {
		// TODO Auto-generated method stub
		// Find contacts by phone number (partial match)
		List<Contact> c1= contactRepository.findByPhoneNumbersContaining(phoneNumber);
		
		//Check contact is Empty or not
		if(c1.isEmpty()) {
			//throw error message if contact is empty
			throw new NumberNotFoundException("Contact Number not found !");
		}else {
			return c1;
		}
		
	
	}

	@Override
	public List<Contact> findAllContact() throws ContactNotFoundException {
		// TODO Auto-generated method stub
		List<Contact> contacts= new ArrayList<>();
		contacts=contactRepository.findAll();
		
		//Check contact is Empty or not
		if(contacts.isEmpty()) {
			
			//throw error message if contact is empty
			throw new ContactNotFoundException("No Contacts found!");
		}else {
			return contacts;
		}
	}

	@Override
	public Contact updateContactdetails(Contact contact) throws ContactNotFoundException {
		// TODO Auto-generated method stub
		Optional<Contact> opt=contactRepository.findById(contact.getId());
		
		//Check contact is Empty or not
		if(opt.isPresent()) {
			Contact c1=opt.get();
//			Contact c2=new Contact();
			c1.setFirstName(contact.getFirstName());
			c1.setLastName(contact.getLastName());
			c1.setEmail(contact.getEmail());
			c1.setPhoneNumbers(contact.getPhoneNumbers());
			contactRepository.save(c1);
			return c1;
		}else {
			//throw error message if contact is empty
			throw new ContactNotFoundException("Contact number Not Found");
		}
		
	}

	@Override
	public Contact addPhoneNumber(String phoneNumber, Integer id) throws ContactNotFoundException {
		// TODO Auto-generated method stub
		Optional<Contact> contact=contactRepository.findById(id);
		
		//Check contact is Empty or not
		if(contact.isEmpty()) {
			throw new ContactNotFoundException("Contact Number Not found");
		}else {
			Contact c1=contact.get();
			
			//add one more contact number  on existing contact
			c1.getPhoneNumbers().add(phoneNumber);
			contactRepository.save(c1);
			return c1;
			
			
		}
		
		
		
	}

	@Override
	public Contact deletePhoneNumber(String phoneNumber,Integer id) throws NumberFormatException {
		// TODO Auto-generated method stub
		Optional<Contact> optional=contactRepository.findById(id);
		
		//Check contact is Empty or not
		if(optional.isEmpty()) {
			//throw error message if contact is empty
			throw new NumberNotFoundException("Contact details not found!");
		}else {
			Contact c1= optional.get();
			
			//remove single number on existing contact number list
			c1.getPhoneNumbers().remove(phoneNumber);
			contactRepository.save(c1);
			return c1;
		}
	
		
	}

	@Override
	public Contact deleteContact(Integer id) throws ContactNotFoundException {
		// TODO Auto-generated method stub
		Optional<Contact> opt=contactRepository.findById(id);
		
		//Check contact is Empty or not
		if(opt.isEmpty()) {
			//throw error message if contact is empty
			throw new ContactNotFoundException("Contact Number Not found With id "+id);
		}else {
			Contact c1=opt.get();
			// Delete contact number
			contactRepository.deleteById(id);
			return c1;
		}
		
	}

	@Override
	public Contact findContactbyid(Integer id) throws ContactNotFoundException {
		// TODO Auto-generated method stub
		//find contact number
		Optional<Contact> conOptional=contactRepository.findById(id);
		
		//Check contact is Empty or not
		if(conOptional.isEmpty()) {
			
			//throw error message if contact is empty
			throw new ContactNotFoundException("Contact Number Not found with id "+ id);
		
		}else {
			Contact c1=new Contact();
			c1=conOptional.get();
			return c1;
			
		}
		
		
	}

}
