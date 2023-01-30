package com.bridgelabz.addressbookapp.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
	@NotNull
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Invalid Name")
	private String name;

	@NotBlank(message = "Address should not be empty")
	private String address;

	@NotBlank(message = "City should not be empty")
	private String city;

	@NotBlank(message = "State should not be empty")
	private String state;

	@NotBlank( message = "Zip should be 6 digits")
	private String zip;

	private String phoneNumber;

	@NotBlank(message = "Email should not be empty")
	private String email;
}
