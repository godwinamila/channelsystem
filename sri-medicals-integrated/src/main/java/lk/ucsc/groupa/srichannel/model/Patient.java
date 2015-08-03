package lk.ucsc.groupa.srichannel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author lruhunage
 *
 */
@Entity
@Table(name = "Patient", uniqueConstraints = @UniqueConstraint(columnNames = {"email","nicNumber"}))
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long patientId;
	
	@NotNull
	private String title;

	@NotNull
	@Size(min = 1, max = 25)
	@NotEmpty(message = "First name cannot be empty")
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	private String firstName;
	
	@NotNull
	private String gender;
	
	@NotNull
    @Size(min = 10, max = 12)
    @Digits(fraction = 0, integer = 12, message = "Incorrect Format, valid e.g. 121212121212")
    @Column(name = "office_tel_number")
	private String officeTele;
	
	@NotNull
    @Size(min = 10, max = 12)
    @Digits(fraction = 0, integer = 12, message = "Incorrect Format, valid e.g. 121212121212")
    @Column(name = "mobile_number")
	private String mobile;
	
	@NotNull
	@NotEmpty(message = "Email address cannot be empty")
	@Email(message = "Invalid email address, e.g. valid email address: example@gmail.com")
	private String email;
	
	private String password;
	
	@NotNull
	@Size(min = 1, max = 25)
	@NotEmpty(message = "Last name cannot be empty")
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	private String lastName;
	
	@NotNull
	@Size(min = 10, max = 10)
	@NotEmpty(message = "NIC cannot be empty")
	@Pattern(regexp = "^\\d{9}[V,v]", message = "must be a valid NIC number")
	private String nicNumber;
	
	@Null
	private String address;
	
	
	public Patient() {
		super();
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOfficeTele() {
		return officeTele;
	}

	public void setOfficeTele(String officeTele) {
		this.officeTele = officeTele;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNicNumber() {
		return nicNumber;
	}

	public void setNicNumber(String nicNumber) {
		this.nicNumber = nicNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
