package App;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.Palavra;
public class AppDemo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		/*
		 * Hibernate configuration
		 */
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory SF = con.buildSessionFactory();
		Session session = SF.openSession();
		org.hibernate.Transaction TR = session.beginTransaction();
		 

		
		
		session.close();

	}

}
