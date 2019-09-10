package cpp.cs4800.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {

	@Id
	@Column(name = "DepartmentName")
	private String departmentName;

	@Column(name = "CollegeName")
	private String collegeName;

	@OneToMany
	@JoinColumn(name = "DepartmentName")
	private Set<Faculty> faculties;

	/**
	 * A default constructor
	 */
	public Department() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param departmentName
	 * @param collegeName
	 */
	public Department(String departmentName, String collegeName) {
		this.departmentName = departmentName;
		this.collegeName = collegeName;
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
	 * @return the collegeName
	 */
	public String getCollegeName() {
		return collegeName;
	}

	/**
	 * @param collegeName the collegeName to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	/**
	 * @return the faculties
	 */
	public Set<Faculty> getFaculties() {
		return faculties;
	}

	/**
	 * @param faculties the faculties to set
	 */
	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}

}
