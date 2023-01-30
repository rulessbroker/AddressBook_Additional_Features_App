package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addressbook_data")
@Data
@NoArgsConstructor
public class AdderssBookModel {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
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
