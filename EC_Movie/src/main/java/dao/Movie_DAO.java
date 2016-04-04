package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecmovie.control.HibernateUtil;
import com.ecmovie.domain.Movie;

public class Movie_DAO {
	
	public void addMovie(Movie movie) throws Exception
	{
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx= null;
		
		try{
			tx = sf.beginTransaction();
			sf.persist(movie);
			tx.commit();
			
		}
		catch(Exception e){
			if(tx!=null ) tx.rollback(); e.printStackTrace();
		    throw new Exception(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> searchMovie(String movie_name)
	{
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		Transaction tx= null;
		List<Movie> movies = new ArrayList<Movie>();
		
		try{
			
			tx = sf.beginTransaction();
			Query criteria = sf.createQuery("From Movie mov where mov.title= :movie_name");
			criteria.setParameter("movie_name", movie_name);
			
			movies= criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return movies;
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> searchMovieByGenere(String movie_genere)
	{
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		Transaction tx= null;
		List<Movie> movies = new ArrayList<Movie>();
		
		try{
			
			tx = sf.beginTransaction();
			Query criteria = sf.createQuery("From movie mov where :movie_genere in elements(mov.genere)");
			criteria.setParameter("movie_genere", movie_genere);
			
			movies= criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return movies;
	}	

	@SuppressWarnings("unchecked")
	public List<Movie> searchMovieByRating(String movie_rating)
	{
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		Transaction tx= null;
		List<Movie> movies = new ArrayList<Movie>();
		
		try{
			
			tx = sf.beginTransaction();
			Query criteria = sf.createQuery("From movie mov where mov.rating= :movie_rating");
			criteria.setParameter("movie_rating", movie_rating);
			
			movies= criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return movies;
	}
	

	public List<Movie> searchMovieByYear(String movie_year)
	{
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		Transaction tx= null;
		List<Movie> movies = new ArrayList<Movie>();
		
		try{
			
			tx = sf.beginTransaction();
			Query criteria = sf.createQuery("From movie mov where mov.year= :movie_year");
			criteria.setParameter("movie_year", movie_year);
			
			movies= criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return movies;
	}
	
	public List<Movie> searchMovieByArtistName(String artist_name)
	{
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		Transaction tx= null;
		List<Movie> movies = new ArrayList<Movie>();
		
		try{
			
			tx = sf.beginTransaction();
			Query criteria = sf.createQuery("From movie mov where mov.artist.name=:artist_name");
			criteria.setParameter("artist_name", artist_name);
			
			movies= criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return movies;
	}	
	
	//This method don't work as of now since character field is not defined in the artist
	public List<Movie> searchMovieByCharacterName(String character_name)
	{
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		Transaction tx= null;
		List<Movie> movies = new ArrayList<Movie>();
		
		try{
			
			tx = sf.beginTransaction();
			Query criteria = sf.createQuery("From movie mov where mov.artist.charctername=:character_name");
			criteria.setParameter("character_name", character_name);
			
			movies= criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return movies;
	}
	
	public List<Movie> searchMovieByDirector(String director_name)
	{
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		@SuppressWarnings("unused")
		Transaction tx= null;
		List<Movie> movies = new ArrayList<Movie>();
		
		try{
			
			tx = sf.beginTransaction();
			Query criteria = sf.createQuery("From movie mov where mov.director.name=:director_name");
			criteria.setParameter("director_name", director_name);
			
			movies= criteria.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return movies;
	}
	
       public Movie retriveMovie(int id) throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {
			
			tx = sf.beginTransaction();
			Movie movie = sf.get(Movie.class, id);
			return movie;
			
		} catch (Exception e) {
			if(tx != null)
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
		
	public void modifyMovie(Movie mov) throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		
		try {
			
			tx = sf.beginTransaction();			
			sf.merge(mov);			
			tx.commit();			
		} catch (Exception e) {

			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);			
		}	
	}
	
	public void deleteMovie(Movie mov)throws Exception{
		
		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;		
		try {			
			tx = sf.beginTransaction();			
			sf.delete(mov);			
			tx.commit();		
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
			throw new Exception(e);			
		}
	}	
}
