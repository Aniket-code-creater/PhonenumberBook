package com.contact.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.Entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	public List<Contact> findByfirstName(String firstName);
	
	public List<Contact> findByPhoneNumbersContaining(String phoneNumber);
	


}
