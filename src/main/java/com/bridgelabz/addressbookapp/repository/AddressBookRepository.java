package com.bridgelabz.addressbookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.bridgelabz.addressbookapp.model.AdderssBookModel;
@EnableJpaRepositories
@Repository
public interface AddressBookRepository extends JpaRepository<AdderssBookModel, Integer> {
	List<AdderssBookModel> getPersonByName(String name);

	List<AdderssBookModel> getPersonDataByCity(String city);

	List<AdderssBookModel> getPersonDataByState(String state);
}
