package cpp.cs4800.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Section")
public class Section implements Serializable {

	@Id
	@Column(name = "Semester")
	private String semester;

	@Id
	@Column(name = "CourseTitle")
	private String courseTitle;

	@Id
	@Column(name = "Section")
	private String section;

	@Id
	@Column(name = "FacultyId")
	private Integer facultyId;

	@Column(name = "DayTime")
	private String dayTime;

	@Column(name = "RoomLocation")
	private String roomLocation;

	/**
	 * A default constructor
	 */
	public Section() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param semester
	 * @param courseNumber
	 * @param section
	 * @param facultyId
	 * @param dayTime
	 * @param roomLocation
	 */
	public Section(String semester, String courseTitle, String section, Integer facultyId, String dayTime,
			String roomLocation) {
		this.semester = semester;
		this.courseTitle = courseTitle;
		this.section = section;
		this.facultyId = facultyId;
		this.dayTime = dayTime;
		this.roomLocation = roomLocation;
	}

	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

	/**
	 * @return the courseTitle
	 */
	public String getCourseTitle() {
		return courseTitle;
	}

	/**
	 * @param courseTitle the courseTitle to set
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	/**
	 * @return the section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * @param section the section to set
	 */
	public void setSection(String section) {
		this.section = section;
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
	 * @return the roomLocation
	 */
	public String getRoomLocation() {
		return roomLocation;
	}

	/**
	 * @param roomLocation the roomLocation to set
	 */
	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}

	@Override
	public int hashCode() {
		return (semester + courseTitle + section + facultyId).hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}

		Section section = (Section) obj;
		if (this.semester.equals(section.getSemester()) && (this.courseTitle.equals(section.getCourseTitle()))
				&& this.section.equals(section.getSection()) && (this.facultyId == section.getFacultyId())) {
			return true;
		}

		return false;
	}

}
