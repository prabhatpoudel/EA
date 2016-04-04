package com.ecmovie.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Director {

	@Id @GeneratedValue
	private int id;
	private String name;
	
	@ManyToMany(mappedBy="director")
	private List<Movie> movie = new ArrayList<Movie>();
	
	
	public Director()
	{
		super();
	}
	
	public Director(String name)
	{
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	public int getId() {
		return id;
	}
	
	
}
