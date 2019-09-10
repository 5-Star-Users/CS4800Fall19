package cpp.cs4800.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {

	@Id
	@Column(name = "CourseNumber")
	private Integer courseNumber;

	@Column(name = "CourseTitle")
	private String courseTitle;

	/**
	 * A default constructor
	 */
	public Course() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param courseNumber
	 * @param courseTitle
	 */
	public Course(Integer courseNumber, String courseTitle) {
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
	}

	/**
	 * @return the courseNumber
	 */
	public Integer getCourseNumber() {
		return courseNumber;
	}

	/**
	 * @param courseNumber the courseNumber to set
	 */
	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
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

}
