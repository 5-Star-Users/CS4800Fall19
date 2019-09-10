package cpp.cs4800.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cpp.cs4800.model.Course;
import cpp.cs4800.model.Department;
import cpp.cs4800.model.Faculty;
import cpp.cs4800.model.OfficeHour;
import cpp.cs4800.model.Section;

/**
 * 
 * @author haohuynh
 * 
 *         A Hibernate controller to manage all Data Access Objects
 */
public class ModelController {

	/**
	 * Hibernate Configuration File Name
	 */
	private static final String HIBERNATE_CONF_FILE = "hibernate.cfg.xml";

	/**
	 * Hibernate Running Package
	 */
	private static final String HIBERNATE_PACKAGE = "cpp.cs4800.model";

	/**
	 * A session factory for the class Department <-> table Department
	 */
	private static SessionFactory departmentFactory;

	/**
	 * A session factory for the class Faculty <-> table Faculty
	 */
	@SuppressWarnings("unused")
	private static SessionFactory facultyFactory;

	/**
	 * A session factory for the class OfficeHour <-> table OfficeHour
	 */
	@SuppressWarnings("unused")
	private static SessionFactory officeHourFactory;

	/**
	 * A session factory for the class Course <-> table Course
	 */
	@SuppressWarnings("unused")
	private static SessionFactory courseFactory;

	/**
	 * A session factory for the class Section <-> table Section
	 */
	@SuppressWarnings("unused")
	private static SessionFactory sectionFactory;

	/**
	 * A singleton Hibernate Model Controller
	 */
	private static ModelController modelController = null;

	/**
	 * A default constructor for initializing all the factories
	 */
	@SuppressWarnings("deprecation")
	private ModelController() {
		/**
		 * Initializing all the factories for Hibernate framework
		 */
		departmentFactory = new Configuration().configure(HIBERNATE_CONF_FILE).addPackage(HIBERNATE_PACKAGE)
				.addAnnotatedClass(Department.class).buildSessionFactory();

		facultyFactory = new Configuration().configure(HIBERNATE_CONF_FILE).addPackage(HIBERNATE_PACKAGE)
				.addAnnotatedClass(Faculty.class).buildSessionFactory();

		officeHourFactory = new Configuration().configure(HIBERNATE_CONF_FILE).addPackage(HIBERNATE_PACKAGE)
				.addAnnotatedClass(OfficeHour.class).buildSessionFactory();

		sectionFactory = new Configuration().configure(HIBERNATE_CONF_FILE).addPackage(HIBERNATE_PACKAGE)
				.addAnnotatedClass(Section.class).buildSessionFactory();

		courseFactory = new Configuration().configure(HIBERNATE_CONF_FILE).addPackage(HIBERNATE_PACKAGE)
				.addAnnotatedClass(Course.class).buildSessionFactory();

	}

	/**
	 * Singleton Access Method
	 * 
	 * @return a instance of ModelController
	 */
	public static ModelController getInstance() {
		if (modelController == null) {
			modelController = new ModelController();
		}
		return modelController;
	}

	/**
	 * List all current departments
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Department> listDepartments() {
		Session session = departmentFactory.openSession();
		Transaction tx = null;
		ArrayList<Department> departments = new ArrayList<Department>();

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Department.class);
			for (Iterator<Department> iterator = criteria.list().iterator(); iterator.hasNext();) {
				departments.add((Department) iterator.next());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.err.println(e.toString());
		} catch (Exception ee) {
			System.err.println(ee.toString());
		} finally {
			session.close();
		}
		return departments;
	}
}
