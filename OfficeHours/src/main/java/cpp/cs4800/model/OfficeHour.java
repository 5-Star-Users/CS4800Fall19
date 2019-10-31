package cpp.cs4800.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "OfficeHour")
public class OfficeHour implements Serializable{

	@Id
	@Column(name = "FacultyId")
	private Integer facultyId;

	@Column(name = "DayTime")
	private String dayTime;

	@Column(name = "Comment")
	private String comment;

	/**
	 * A default constructor
	 */
	public OfficeHour() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param facultyId
	 * @param dayTime
	 * @param comment
	 */
	public OfficeHour(Integer facultyId, String dayTime, String comment) {
		this.facultyId = facultyId;
		this.dayTime = dayTime;
		this.comment = comment;
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
	 * @return the dayTime
	 */
	public String getDayTime() {
		return dayTime;
	}

	/**
	 * @param dayTime the dayTime to set
	 */
	public void setDayTime(String dayTime) {
		this.dayTime = dayTime;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		return (facultyId + dayTime).hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}

		OfficeHour officeHour = (OfficeHour) obj;
		if ((this.facultyId == officeHour.getFacultyId()) && (this.dayTime.equals(officeHour.getDayTime()))) {
			return true;
		}

		return false;
	}

}
