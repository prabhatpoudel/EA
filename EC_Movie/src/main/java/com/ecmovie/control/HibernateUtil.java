package com.ecmovie.control;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.ecmovie.domain.Artist;
import com.ecmovie.domain.Director;
import com.ecmovie.domain.Movie;
import com.ecmovie.domain.Picture;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static{
		try {
			
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Director.class);
			configuration.addAnnotatedClass(Artist.class);
			configuration.addAnnotatedClass(Movie.class);
			configuration.addAnnotatedClass(Picture.class);
			configuration.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			
		} catch (Throwable e) {
			
			e.printStackTrace();	
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
