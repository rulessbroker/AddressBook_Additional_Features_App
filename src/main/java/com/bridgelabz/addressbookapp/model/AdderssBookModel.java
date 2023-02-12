package com.bridgelabz.addressbookapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;	

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "addressbook")
@Data
@NoArgsConstructor
public class AdderssBookModel {
	@Id
	private int id;
	@Indexed(unique=true)
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String email;

	public AdderssBookModel(AdderssBookModel addressBook) {
	}

	public AdderssBookModel(AddressBookDTO addressBookDTO) {
		this.updatePersonData(addressBookDTO);
	}

	public void updatePersonData(AddressBookDTO addressBookDTO) {
		this.name = addressBookDTO.getName();
		this.address = addressBookDTO.getAddress();
		this.city = addressBookDTO.getCity();
		this.state = addressBookDTO.getState();
		this.zip = addressBookDTO.getZip();
		this.phoneNumber = addressBookDTO.getPhoneNumber();
		this.email = addressBookDTO.getEmail();
	}
}
