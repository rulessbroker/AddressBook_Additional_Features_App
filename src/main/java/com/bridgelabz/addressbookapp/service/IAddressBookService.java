package com.bridgelabz.addressbookapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AdderssBookModel;

@Service
public interface IAddressBookService {
	AdderssBookModel createPersonContact(AddressBookDTO addressBookDTO);

	List<AdderssBookModel> getAllPersonRecords();

	AdderssBookModel getPersonRecordById(int id);

	AdderssBookModel updatePersonRecordById(int id, AddressBookDTO addressBookDTO);

	void deletePersonRecordById(int id);

	public List<AdderssBookModel> getPersonRecordByName(String name);

	public List<AdderssBookModel> getPersonRecordByCity(String city);

	public List<AdderssBookModel> getPersonRecordByState(String state);

	String createRecordAndToken(AddressBookDTO addressBookDTO);

	AdderssBookModel getRecordByToken(String token);

	AdderssBookModel updateRecordByToken(String token, AddressBookDTO addressBookDTO);

	AdderssBookModel deletePersonRecordByToken(String token);
}
