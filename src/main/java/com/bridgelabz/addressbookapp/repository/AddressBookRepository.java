package com.bridgelabz.addressbookapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.bridgelabz.addressbookapp.model.AdderssBookModel;

@EnableMongoRepositories
@Repository
public interface AddressBookRepository extends MongoRepository<AdderssBookModel, Integer> {
	List<AdderssBookModel> getPersonByName(String name);

	List<AdderssBookModel> getPersonDataByCity(String city);

	List<AdderssBookModel> getPersonDataByState(String state);
}
