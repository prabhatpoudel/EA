package com.ecmovie.control;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ecmovie.domain.Artist;
import com.ecmovie.domain.Director;
import com.ecmovie.domain.Genere;
import com.ecmovie.domain.Movie;
import com.ecmovie.domain.Picture;
import com.ecmovie.domain.Rating;

import dao.Artist_DAO;
import dao.Director_DAO;
import dao.Movie_DAO;
import dao.Picture_DAO;

public class Driver {
/*	private static EntityManagerFactory emf;
	private static EntityManager em;*/

	/*static {
		try {
			emf = Persistence.createEntityManagerFactory("EC_Movie");
			em = emf.createEntityManager();
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}*/
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		addRecords();
		displayArtist();
		displayMovies();
//		emf.close();
	}


	public static void addRecords() throws IOException {
//		Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = sf.beginTransaction();
				/*		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();*/
		try {
//			tx.begin();

			Path p = FileSystems.getDefault().getPath("src/main/resources/images/", "jpt.PNG");
			byte[] fileData = Files.readAllBytes(p);

			Artist prabhat = new Artist("Prabhat Poudel", "10-10-1988", "Nepal", "I am a famous actor from Neapl.");// ,pics);
			Picture pic = new Picture(fileData);

			Picture pic1 = new Picture(fileData);
			pic1.setPic(fileData);

			pic.setArtist(prabhat);
			pic1.setArtist(prabhat);
			
			Movie TLove = new Movie("Poster","Love and Romance","True Love","1999",Rating.EXCELLENT);
			TLove.getArtist().add(prabhat);
			TLove.setGenere(Arrays.asList(Genere.LOVE));
			TLove.setComment(Arrays.asList("HeartTouching Love Story","Nice"));
			
			Director anish = new Director("Anish Panthi");
			TLove.getDirector().add(anish);

//			Artist_DAO artist_dao= new Artist_DAO();
//			artist_dao.addArtist(prabhat);
			
			Movie_DAO movie_dao= new Movie_DAO();
			movie_dao.addMovie(TLove);
			
/*			Picture_DAO pic_dao1= new Picture_DAO();
			pic_dao1.addPicture(pic);

			Picture_DAO pic_dao2= new Picture_DAO();
			pic_dao2.addPicture(pic1);
			
			Director_DAO director_dao= new Director_DAO();
			director_dao.addDirector(anish);
*/			
/*			sf.persist(TLove);
			sf.persist(prabhat);
			sf.persist(pic);
			sf.persist(pic1);
			sf.persist(anish);

			tx.commit();*/
		} catch (Throwable e) {
/*			if

			((tx != null))
				tx.rollback();*/
			e.printStackTrace();

		} /*finally {
			if ((sf != null) && (sf.isOpen()))
				sf.close();
		}*/

	}
	
	public static void displayMovies()
	{
		Movie_DAO movie_dao= new Movie_DAO();
		List<Movie> movies = movie_dao.searchMovieByYear("1999");
		
		for(Movie mov: movies)
		{
			System.out.println("Name: "+mov.getTitle());
			System.out.println("Summary: "+mov.getSummary());
			System.out.println("Rating: "+mov.getRating());
			System.out.println("Year: "+mov.getYear());
			System.out.println("Director: "+mov.getDirector());
			System.out.println("Artist: "+mov.getArtist());
			System.out.println("Genere: "+mov.getGenere());
		}
	}
	
	public static void displayArtist()
	{
		Movie_DAO movie_dao= new Movie_DAO();
		List<Movie> movies = movie_dao.searchMovieByArtistName("Prabhat Poudel");
		
		for(Movie mov: movies)
		{
			System.out.println("Name: "+mov.getTitle());
			System.out.println("Summary: "+mov.getSummary());
			System.out.println("Rating: "+mov.getRating());
			System.out.println("Year: "+mov.getYear());
			System.out.println("Director: "+mov.getDirector());
			System.out.println("Artist: "+mov.getArtist());
			System.out.println("Genere: "+mov.getGenere());
		}
	}

}
