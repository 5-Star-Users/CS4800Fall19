package cpp.cs4800.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

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
	 * Multiple delimiters R.E.
	 */
	private static final String DELIMITERS = "[\\s\\t\\[\\]\\{\\}\\(\\)\\*\\/.,!@_#$:]+";

	/**
	 * A session factory for the class Faculty <-> table Faculty
	 */
	@SuppressWarnings("unused")
	private static SessionFactory facultyFactory;

	/**
	 * A session factory for the class Faculty <-> table Faculty
	 */
	@SuppressWarnings("unused")
	private static SessionFactory officeHourFactory;
	
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
		officeHourFactory = new Configuration().configure(HIBERNATE_CONF_FILE).addPackage(HIBERNATE_PACKAGE)
				.addAnnotatedClass(OfficeHour.class).buildSessionFactory();
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
			return null;
		} catch (Exception ee) {
			return null;
		} finally {
			session.close();
		}
		return faculty;
	}
	
	@SuppressWarnings("unchecked")
	public static Faculty getFaculty(int id) {
		Session session = facultyFactory.openSession();
		Transaction tx = null;
		Faculty faculty = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Faculty.class);

			criteria.add(Restrictions.like("facultyId", id));

			faculty = ((Faculty) criteria.list().iterator().next());
//				if (faculty.getFacultyId() != id) {  unnecessary unless possible for facluty to have same id
//					faculty = null;
//				}
//			}
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
	 * To find a faculty having the Bronco ID like username and update his/her info
	 */
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
	 * To find a faculty having the Bronco ID like username and update his/her info
	 */
	public static OfficeHour updateOfficeHour(OfficeHour officeHour) {
		Session session = officeHourFactory.openSession();
		Transaction tx = null;
		OfficeHour hour = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(OfficeHour.class);

			criteria.add(Restrictions.eq("facultyId", officeHour.getFacultyId()));

			hour = ((OfficeHour) criteria.list().iterator().next());

			if (hour != null) {
				hour.setDayTime(officeHour.getDayTime());
				hour.setComment(officeHour.getComment());
				session.update(hour);
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
		return hour;
	}
	

	/**
	 * To find a faculty that satisfies the seaching criteria
	 */
	@SuppressWarnings("unchecked")
	public static Set<Faculty> listFaculty(String searchString) {
		Session session = facultyFactory.openSession();
		Transaction tx = null;
		Set<Faculty> results = new HashSet<Faculty>();

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Faculty.class);

			if ((searchString != null) && !searchString.equals("")) {

				String[] searchStrings = searchString.split(DELIMITERS);
				Criterion fNameCriterion = null, lNameCriterion = null, departmentCriterion = null;
				boolean[] appliedCriteria = { true, true, true };

				if (!searchStrings[0].equals("")) {
					fNameCriterion = Restrictions.like("firstName", "%" + searchStrings[0] + "%");
					lNameCriterion = Restrictions.like("lastName", "%" + searchStrings[0] + "%");
					departmentCriterion = Restrictions.like("departmentName", "%" + searchStrings[0] + "%");
				}

				for (int i = 1; i < searchStrings.length; i++) {
					if (!searchStrings[i].equals("")) {
						fNameCriterion = Restrictions.or(fNameCriterion,
								Restrictions.like("firstName", "%" + searchStrings[i] + "%"));
						lNameCriterion = Restrictions.or(lNameCriterion,
								Restrictions.like("lastName", "%" + searchStrings[i] + "%"));
						departmentCriterion = Restrictions.or(departmentCriterion,
								Restrictions.like("departmentName", "%" + searchStrings[i] + "%"));
					}

				}

				criteria.add(fNameCriterion);
				if (criteria.list().isEmpty()) {
					appliedCriteria[0] = false;
					criteria = session.createCriteria(Faculty.class);
				}

				criteria.add(lNameCriterion);
				if (criteria.list().isEmpty()) {
					appliedCriteria[1] = false;
					criteria = session.createCriteria(Faculty.class);
					if (appliedCriteria[0]) {
						criteria.add(fNameCriterion);
					}
				}

				criteria.add(departmentCriterion);
				if (criteria.list().isEmpty()) {

					appliedCriteria[2] = false;
					criteria = session.createCriteria(Faculty.class);

					if (appliedCriteria[0]) {
						criteria.add(fNameCriterion);
					}

					if (appliedCriteria[1]) {
						criteria.add(lNameCriterion);
					}
				}

				for (Iterator<Faculty> iterator = criteria.list().iterator(); iterator.hasNext();) {
					results.add(((Faculty) iterator.next()));
				}

				if (Pattern.compile("[0-9]").matcher(searchString).find()) {
					Set<Faculty> removeList = new HashSet<Faculty>();

					for (Faculty faculty : results) {
						Boolean flag = false;

						for (Section section : faculty.getSections()) {

							for (int j = 0; j < searchStrings.length; j++) {
								if (section.getCourseTitle().contains(searchStrings[j])) {
									flag = true;
								}
							}

						}

						if (!flag) {
							removeList.add(faculty);
						}

					}

					results.removeAll(removeList);

				} else {
					if (!appliedCriteria[0] && !appliedCriteria[1] && !appliedCriteria[2]) {
						results.clear();
					}
				}

			}

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
//TODO marker to remember to delete test code
//	public static void main(String[] args) {
//		Faculty temp = ModelController.getInstance().getFaculty(20);
//		if(temp == null)
//			System.out.println("null");
//		System.out.println(temp.getFirstName());
//	}
	
}
