package com.contact.Entity;

import java.util.List;

import org.hibernate.validator.constraints.Email;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	@Email
	private String email;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="phone_numbers", joinColumns = @JoinColumn(name="contact_id"))
	private List<String> phoneNumbers;

}
