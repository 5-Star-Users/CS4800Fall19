package cpp.cs4800.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Faculty")
public class Faculty {

	@Id
	@Column(name = "FacultyId")
	private Integer facultyId;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@Column(name = "EmailAddress")
	private String emailAddress;

	@Column(name = "OfficeLocation")
	private String officeLocation;

	@Column(name = "DepartmentName")
	private String departmentName;

	@Column(name = "PassPhrase")
	private String passPhrase;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "FacultyId")
	private Set<OfficeHour> officeHours;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "FacultyId")
	private Set<Section> sections;

	/**
	 * A default constructor
	 */
	public Faculty() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param facultyId
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param emailAddress
	 * @param officeLocation
	 * @param departmentName
	 * @param officeHours
	 * @param sections
	 */
	public Faculty(Integer facultyId, String firstName, String lastName, String phoneNumber, String emailAddress,
			String officeLocation, String departmentName, Set<OfficeHour> officeHours, Set<Section> sections) {
		this.facultyId = facultyId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.officeLocation = officeLocation;
		this.departmentName = departmentName;
		this.officeHours = officeHours;
		this.sections = sections;
	}

	/**
	 * @return the facultyId
	 */
	public Integer getFacultyId() {
		return facultyId;
	}

	/**
	 * @param facultyId the facultyId to set
	 */
	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the officeLocation
	 */
	public String getOfficeLocation() {
		return officeLocation;
	}

	/**
	 * @param officeLocation the officeLocation to set
	 */
	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the officeHours
	 */
	public Set<OfficeHour> getOfficeHours() {
		return officeHours;
	}

	/**
	 * @param officeHours the officeHours to set
	 */
	public void setOfficeHours(Set<OfficeHour> officeHours) {
		this.officeHours = officeHours;
	}

	/**
	 * @return the sections
	 */
	public Set<Section> getSections() {
		return sections;
	}

	/**
	 * @param sections the sections to set
	 */
	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	/**
	 * @return the passPhrase
	 */
	public String getPassPhrase() {
		return passPhrase;
	}

	/**
	 * @param passPhrase the passPhrase to set
	 */
	public void setPassPhrase(String passPhrase) {
		this.passPhrase = passPhrase;
	}

}
