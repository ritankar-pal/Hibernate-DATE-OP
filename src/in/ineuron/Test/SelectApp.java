package in.ineuron.Test;
import java.io.Serializable;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.PersonInfo;
import in.ineuron.util.HibernateUtil;


public class SelectApp {

	public static void main(String[] args) {
		
		Session session = null; 
		int id = 1;

		
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				PersonInfo personInfo = session.get(PersonInfo.class, id);
				
				if(personInfo != null) {
					System.out.println(personInfo);
				}
				else {
					System.out.println("Record Not Found for the given ID:: " + id);
				}
				
			}
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {	
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
