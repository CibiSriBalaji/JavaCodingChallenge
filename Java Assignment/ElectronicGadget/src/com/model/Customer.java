package com.model;

public class Customer {
	
	private int CustomerID;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Phone;
	private String Address;
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "Customer [CustomerID=" + CustomerID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email="
				+ Email + ", Phone=" + Phone + ", Address=" + Address + "]";
	}
	public Customer(int customerID, String firstName, String lastName, String email, String phone, String address) {
		super();
		CustomerID = customerID;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Phone = phone;
		Address = address;
	}
	public Customer() {
		super();
	}
	
}
