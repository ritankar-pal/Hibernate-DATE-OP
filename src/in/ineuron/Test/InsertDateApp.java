package in.ineuron.Test;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.PersonInfo;
import in.ineuron.util.HibernateUtil;


public class InsertDateApp {

	public static void main(String[] args) {
		
		Session session = null; 
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null;
		
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				 transaction = session.beginTransaction();
			}
			
			if(transaction != null) {
				
				PersonInfo personInfo = new PersonInfo();
				personInfo.setPname("Ramesh");
				personInfo.setDob(LocalDate.of(1999, 07, 15));
				personInfo.setDoj(LocalTime.of(9, 30));
				personInfo.setDom(LocalDateTime.of(2024, 03, 05, 05, 45));
				
				
				id = (Integer)session.save(personInfo);
				flag = true;
			}
			
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("Object updated to the database with the PK ID:: " + id);
			}
			else {
				transaction.rollback();
				System.out.println("Object failed to update...");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
