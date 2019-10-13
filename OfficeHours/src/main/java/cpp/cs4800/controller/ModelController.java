package cpp.cs4800.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import cpp.cs4800.model.Faculty;
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
	 * A session factory for the class Faculty <-> table Faculty
	 */
	@SuppressWarnings("unused")
	private static SessionFactory facultyFactory;

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
		 * Initializing the Faculty factory for Hibernate framework
		 */
		facultyFactory = new Configuration().configure(HIBERNATE_CONF_FILE).addPackage(HIBERNATE_PACKAGE)
				.addAnnotatedClass(Faculty.class).buildSessionFactory();
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
	 * To find a faculty that satisfies the seaching criteria
	 */
	@SuppressWarnings("unchecked")
	public static Set<Faculty> listFaculty(String firstName, String lastName, String departmentName,
			String courseTitle) {
		Session session = facultyFactory.openSession();
		Transaction tx = null;
		Set<Faculty> results = new HashSet<Faculty>();

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Faculty.class);

			if ((firstName != null) && !firstName.equals("")) {
				criteria.add(Restrictions.like("firstName", "%" + firstName.trim() + "%"));
			}

			if ((lastName != null) && !lastName.equals("")) {
				criteria.add(Restrictions.like("lastName", "%" + lastName.trim() + "%"));
			}

			if ((departmentName != null) && !departmentName.equals("")) {
				criteria.add(Restrictions.like("departmentName", "%" + departmentName.trim() + "%"));
			}

			for (Iterator<Faculty> iterator = criteria.list().iterator(); iterator.hasNext();) {
				results.add(((Faculty) iterator.next()));
			}

			Set<Faculty> removeList = new HashSet<Faculty>();
			if ((courseTitle != null) && !courseTitle.equals("")) {
				for (Faculty faculty : results) {
					Boolean flag = false;
					for (Section section : faculty.getSections()) {
						if (section.getCourseTitle().contains(courseTitle)) {
							flag = true;
						}
					}
					if (!flag) {
						removeList.add(faculty);
					}

				}
			}

			results.removeAll(removeList);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			return new HashSet<Faculty>();

		} catch (Exception ee) {
			return new HashSet<Faculty>();

		} finally {
			session.close();
		}
		return results;
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
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(SALT.getBytes(StandardCharsets.UTF_8));

			byte[] bytes = messageDigest.digest(passphrase.getBytes(StandardCharsets.UTF_8));
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
