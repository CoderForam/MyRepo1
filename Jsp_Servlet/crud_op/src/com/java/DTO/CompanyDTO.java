package com.java.DTO;

public class CompanyDTO {
	private int id;
	private String Name;
	private String Email;
	private String Address;
	private String City;
	private String Gender;
	private String Language;
	private String Date_of_Birth;
	private String Blood_Group;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getDate_of_Birth() {
		return Date_of_Birth;
	}
	public void setDate_of_Birth(String date_of_Birth) {
		Date_of_Birth = date_of_Birth;
	}
	
	public String getBlood_Group() {
		return Blood_Group;
	}
	public void setBlood_Group(String blood_Group) {
		Blood_Group = blood_Group;
	}
	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", Name=" + Name + ", Email=" + Email + ", Address=" + Address + ", City="
				+ City + ", Gender=" + Gender + ", Language=" + Language + ", Date_of_Birth=" + Date_of_Birth
				+ ", Blood_Group=" + Blood_Group + "]";
	}
}