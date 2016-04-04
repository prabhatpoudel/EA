package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecmovie.control.HibernateUtil;
import com.ecmovie.domain.Artist;


public class Artist_DAO {
	
	public void addArtist(Artist artist) throws Exception
	{
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= sf.getTransaction();
		
		try{
			tx.begin();
			sf.persist(artist);
			
		}
		catch(Exception e){
			if(tx!=null ) tx.rollback(); e.printStackTrace();
		    throw new Exception(e);
		}
	}
	
    public Artist retriveartist(int id) throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			
			tx = sf.beginTransaction();
			Artist artist = sf.get(Artist.class, id);
			return artist;
			
		} catch (Exception e) {
			if(tx != null)
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
		
	public void modifyArtist(Artist art) throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			
			tx = sf.beginTransaction();			
			sf.merge(art);			
			tx.commit();			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);			
		}	
	}
	
	public void deleteArtist(Artist art)throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;		
		try {			
			tx = sf.beginTransaction();			
			sf.delete(art);			
			tx.commit();		
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);			
		}
	}	

}
