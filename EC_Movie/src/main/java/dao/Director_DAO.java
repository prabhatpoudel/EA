package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecmovie.control.HibernateUtil;
import com.ecmovie.domain.Director;

public class Director_DAO {
	public void addDirector(Director director) throws Exception {

		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = sf.getTransaction();

		try {
			tx.begin();
			sf.persist(director);

		} catch (Exception e) {
			if (tx != null)
			{
				tx.rollback(); e.printStackTrace();
			throw new Exception(e);
			}
		}
	}
    public Director retriveMovie(int id) throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			
			tx = sf.beginTransaction();
			Director direct = sf.get(Director.class, id);
			return direct;
			
		} catch (Exception e) {
			if(tx != null)
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
		
	public void modifyMovie(Director direct) throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			
			tx = sf.beginTransaction();			
			sf.merge(direct);			
			tx.commit();			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);			
		}	
	}
	
	public void deleteMovie(Director direct)throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;		
		try {			
			tx = sf.beginTransaction();			
			sf.delete(direct);			
			tx.commit();		
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);			
		}
	}
}
