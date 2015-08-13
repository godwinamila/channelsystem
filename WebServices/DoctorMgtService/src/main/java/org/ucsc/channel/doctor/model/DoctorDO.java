package org.ucsc.channel.doctor.model;

import java.io.Serializable;

public class DoctorDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4264896614037023207L;
	private String number;
	private String title;
	private String firstName;
	private String lastName;
	private String gender;
	private String offTelephone;
	private String mobile;
	private String email;
	private String idn;
	private String address;
	private String speciality;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOffTelephone() {
		return offTelephone;
	}

	public void setOffTelephone(String offTelephone) {
		this.offTelephone = offTelephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdn() {
		return idn;
	}

	public void setIdn(String idn) {
		this.idn = idn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	

}
