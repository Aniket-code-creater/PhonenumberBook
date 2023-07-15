package com.contact.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contact.Entity.Contact;
import com.contact.Services.ContactService;


//@Controller + @ResponseBody= @RestController
@RestController
//Base URL
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	
	@PostMapping("/createcontact")
	public ResponseEntity<Contact> AddContact(@RequestBody Contact contact){
		
		//Add a New contact
		Contact c1=contactService.addContact(contact);
		return new ResponseEntity<>(c1,HttpStatus.CREATED);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Contact> FindContactById(@PathVariable Integer id){
		
		//Find contact by Contact Id
		Contact c1= new Contact();
		c1=contactService.findContactbyid(id);
		return new ResponseEntity<>(c1, HttpStatus.OK);
	}
	
	@GetMapping("search/name/{firstname}")
	public ResponseEntity<List<Contact>> findContactByName(@PathVariable String firstname){
		
		//find contact By contact Name
		List<Contact> list= new ArrayList<>();
		list=contactService.findbyName(firstname);
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/search/number/{phoneNumber}")
	public ResponseEntity<List<Contact>> FindcontactByNumber(@PathVariable String phoneNumber){
		
		//find contact Details by contact Phone Number
		List<Contact> c1= contactService.findbyNumbers(phoneNumber);
		
		return new ResponseEntity<>(c1, HttpStatus.OK);
	}
	
	@GetMapping("/allcontacts")
	public ResponseEntity<List<Contact>> FindAllContact(){
		
		//find All Contacts Numbers List
		List<Contact> list=new ArrayList<>();
		list=contactService.findAllContact();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Contact> UpdateContactDetails(@RequestBody Contact contact){
		
		//Update Contact Details
		Contact c1=contactService.updateContactdetails(contact);
		return new ResponseEntity<>(c1, HttpStatus.OK);
	}
	
	@PostMapping("/add/newnumber/{id}")
	public ResponseEntity<Contact> adddMoreContactNumber(@RequestParam String phoneNumber, @PathVariable Integer id){
		
		//Add One More contact number in existing Contact
		Contact c1=contactService.addPhoneNumber(phoneNumber, id);
		return new ResponseEntity<>(c1,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/one/number/{id}")
	public ResponseEntity<Contact> DeleteOnecontactNumberById(String phoneNuber,@PathVariable Integer id){
		
		//delete existing Contact number only using contact number and id;
		Contact c1= contactService.deletePhoneNumber(phoneNuber, id);
		return new ResponseEntity<>(c1,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/contact/{id}")
	public ResponseEntity<Contact> DeletecontactbyId(@PathVariable Integer id){
		
		
		//delete Existing contact
		Contact c1= contactService.deleteContact(id);
		return new ResponseEntity<>(c1,HttpStatus.OK);
	}
	

}
