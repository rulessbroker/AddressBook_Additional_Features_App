package com.bridgelabz.addressbookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AdderssBookModel;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import com.bridgelabz.addressbookapp.util.EmailService;
import com.bridgelabz.addressbookapp.util.TokenUtil;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private AddressBookRepository addressBookRepository;

	@Autowired
	TokenUtil tokenUtil;

	@Autowired
	EmailService email;

	@Override
	public List<AdderssBookModel> getAllPersonRecords() {

		return addressBookRepository.findAll();
	}

	@Override
	public AdderssBookModel createPersonContact(AddressBookDTO addressBookDTO) {
		AdderssBookModel addressbookData = new AdderssBookModel(addressBookDTO);
		String token = tokenUtil.createToken(addressbookData.getId());
		email.sendEmail(addressbookData.getEmail(), "Test Mail",
				"Hii...." + addressbookData.getName() + " your details are added!\n\n Name:  "
						+ addressbookData.getName() + "\n Phone number:  " + addressbookData.getPhoneNumber()
						+ "\n Email:  " + addressbookData.getEmail() + "\n Address:  " + addressbookData.getAddress()
						+ "\n City:  " + addressbookData.getCity() + "\n State:  " + addressbookData.getState()
						+ "\n ZipCode:  " + addressbookData.getZip() + "\n Token: " + token);
		return addressBookRepository.save(addressbookData);
	}

	@Override
	public AdderssBookModel getPersonRecordById(int id) {
		return addressBookRepository.findById(id)
				.orElseThrow(() -> new AddressBookException("Person with id" + id + "doesnt exist!!"));

	}

	@Override
	public AdderssBookModel updatePersonRecordById(int id, AddressBookDTO addressBookDTO) {
		AdderssBookModel addressBookData = this.getPersonRecordById(id);
		addressBookData.updatePersonData(addressBookDTO);
		return addressBookRepository.save(addressBookData);

	}

	@Override
	public void deletePersonRecordById(int id) {
		AdderssBookModel addressBookData = this.getPersonRecordById(id);
		addressBookRepository.delete(addressBookData);
		email.sendEmail(addressBookData.getEmail(), "Test Mail", "Hii....! Your details has been deleted!");
	}

	@Override
	public List<AdderssBookModel> getPersonRecordByName(String name) {
		return addressBookRepository.getPersonByName(name);
	}

	@Override
	public List<AdderssBookModel> getPersonRecordByCity(String city) {
		return addressBookRepository.getPersonDataByCity(city);
	}

	@Override
	public List<AdderssBookModel> getPersonRecordByState(String state) {
		return addressBookRepository.getPersonDataByState(state);
	}

	@Override
	public String createRecordAndToken(AddressBookDTO addressBookDTO) {
		AdderssBookModel addressbookData = new AdderssBookModel(addressBookDTO);
		addressBookRepository.save(addressbookData);
		String token = tokenUtil.createToken(addressbookData.getId());
		email.sendEmail(addressbookData.getEmail(), "Test Mail",
				"Hii...." + addressbookData.getName() + " your details are added!\n\n Name:  "
						+ addressbookData.getName() + "\n Phone number:  " + addressbookData.getPhoneNumber()
						+ "\n Email:  " + addressbookData.getEmail() + "\n Address:  " + addressbookData.getAddress()
						+ "\n City:  " + addressbookData.getCity() + "\n State:  " + addressbookData.getState()
						+ "\n ZipCode:  " + addressbookData.getZip() + "\n Token: " + token);
		return token;

	}

	@Override
	public AdderssBookModel getRecordByToken(String token) {
		int id = tokenUtil.decodeToken(token);
		AdderssBookModel addressBookData = addressBookRepository.findById(id).get();
		return addressBookData;
	}

	@Override
	public AdderssBookModel updateRecordByToken(String token, AddressBookDTO addressBookDTO) {
		int id = tokenUtil.decodeToken(token);
		AdderssBookModel addressBookData = this.getPersonRecordById(id);
		addressBookData.updatePersonData(addressBookDTO);
		return addressBookRepository.save(addressBookData);

	}

	@Override
	public AdderssBookModel deletePersonRecordByToken(String token) {
		int id = tokenUtil.decodeToken(token);
		if (addressBookRepository.findById(id).isPresent()) {
			AdderssBookModel addressBookModel = addressBookRepository.findById(id).get();
			addressBookRepository.deleteById(id);
			email.sendEmail(addressBookModel.getEmail(), "Test Mail", "Hii....! Your details has been deleted!");
			return addressBookModel;
		} else {
			throw new AddressBookException("Invalid token ");
		}

	}

}
