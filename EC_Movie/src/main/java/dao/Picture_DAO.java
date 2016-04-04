package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecmovie.control.HibernateUtil;
import com.ecmovie.domain.Picture;

public class Picture_DAO {
	
	public void addPicture(Picture pic) throws Exception
	{

		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= sf.getTransaction();
		
		try{
			tx.begin();
			sf.persist(pic);
			
		}
		catch(Exception e){
			if(tx!=null ) tx.rollback(); e.printStackTrace();
		    throw new Exception(e);
		}
	}
    public Picture retriveMovie(int id) throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			
			tx = sf.beginTransaction();
			Picture pic = sf.get(Picture.class, id);
			return pic;
			
		} catch (Exception e) {
			if(tx != null)
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
		
	public void modifyPicture(Picture pic) throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			
			tx = sf.beginTransaction();			
			sf.merge(pic);			
			tx.commit();			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);			
		}	
	}
	
	public void deletePicture(Picture pic)throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;		
		try {			
			tx = sf.beginTransaction();			
			sf.delete(pic);			
			tx.commit();		
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);			
		}
	}
}
