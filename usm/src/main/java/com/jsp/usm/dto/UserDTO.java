package com.jsp.usm.dto;

public class UserDTO 
{
	private String firstName;
	private String lastName;
	private String email;
	private String country;
	private String mobileNumber;
	private String pincode;
	
	public String getFirstName() 
	{
		return firstName;
	}
	@Override
	public String toString() 
	{
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", country="
				+ country + ", mobileNumber=" + mobileNumber + ", pincode=" + pincode + "]";
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	

}
