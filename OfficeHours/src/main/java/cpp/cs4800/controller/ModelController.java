package cpp.cs4800.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

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
	 * A salt for the SHA-512
	 */
	private static final String SALT = "FiveStartUsersFall2019";

	/**
	 * CPP email post fix
	 */
	private static final String EMAIL_POSTFIX = "@cpp.edu";

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

	/**
	 * List all current faculties
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Faculty> listFaculties() {
		Session session = facultyFactory.openSession();
		Transaction tx = null;
		ArrayList<Faculty> faculties = new ArrayList<Faculty>();

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Faculty.class);
			for (Iterator<Faculty> iterator = criteria.list().iterator(); iterator.hasNext();) {
				faculties.add((Faculty) iterator.next());
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
		return faculties;
	}

	/**
	 * To find a faculty that have the Bronco ID and password like username and
	 * passphrase
	 */
	@SuppressWarnings("unchecked")
	public static Faculty getFaculty(String username, String passphrase) {
		Session session = facultyFactory.openSession();
		Transaction tx = null;
		Faculty faculty = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Faculty.class);

			criteria.add(Restrictions.like("emailAddress", username + EMAIL_POSTFIX));

			for (Iterator<Faculty> iterator = criteria.list().iterator(); iterator.hasNext();) {
				faculty = ((Faculty) iterator.next());
				if (!getHashedPassphrase(passphrase).equals(faculty.getPassPhrase())) {
					faculty = null;
				}
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
		return faculty;
	}

	/**
	 * To find a faculty having the Bronco ID like username
	 */
	@SuppressWarnings("unchecked")
	public static Faculty getFaculty(String username) {
		Session session = facultyFactory.openSession();
		Transaction tx = null;
		Faculty faculty = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Faculty.class);

			criteria.add(Restrictions.like("emailAddress", username + EMAIL_POSTFIX));

			faculty = ((Faculty) criteria.list().iterator().next());

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
		return faculty;
	}

	/**
	 * To find a faculty having the Bronco ID like username and update his/her info
	 */
	@SuppressWarnings("unchecked")
	public static Faculty updateFaculty(String username, String otp) {
		Session session = facultyFactory.openSession();
		Transaction tx = null;
		Faculty faculty = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Faculty.class);

			criteria.add(Restrictions.like("emailAddress", username + EMAIL_POSTFIX));

			faculty = ((Faculty) criteria.list().iterator().next());

			if (faculty != null) {
				faculty.setPassPhrase(getHashedPassphrase(otp));
				session.update(faculty);
			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			return null;
		} catch (Exception ee) {
			return null;
		} finally {
			session.close();
		}
		return faculty;
	}

	/**
	 * List all current office hours
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<OfficeHour> listOfficeHours() {
		Session session = officeHourFactory.openSession();
		Transaction tx = null;
		ArrayList<OfficeHour> officeHours = new ArrayList<OfficeHour>();

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(OfficeHour.class);
			for (Iterator<OfficeHour> iterator = criteria.list().iterator(); iterator.hasNext();) {
				officeHours.add((OfficeHour) iterator.next());
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
		return officeHours;
	}

	/**
	 * List all current sections
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Section> listSections() {
		Session session = sectionFactory.openSession();
		Transaction tx = null;
		ArrayList<Section> sections = new ArrayList<Section>();

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Section.class);
			for (Iterator<Section> iterator = criteria.list().iterator(); iterator.hasNext();) {
				sections.add((Section) iterator.next());
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
		return sections;
	}

	/**
	 * Hash the pass phrase into a hashed code
	 * 
	 * @param passphrase
	 * 
	 */
	public static String getHashedPassphrase(String passphrase) {
		String hashedCode = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(SALT.getBytes(StandardCharsets.UTF_8));

			byte[] bytes = md.digest(passphrase.getBytes(StandardCharsets.UTF_8));
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			hashedCode = stringBuilder.toString();
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e.toString());
		}
		return hashedCode;
	}
}
