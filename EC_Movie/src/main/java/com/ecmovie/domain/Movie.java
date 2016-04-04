package com.ecmovie.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.Cascade;



@Entity
public class Movie {

	@Id @GeneratedValue
	private int id;
	private String poster;
	private String summary;
	private String title;
	private String year;
	
	@Enumerated(EnumType.STRING)
	private Rating rating;
	
	@ManyToMany 
	@JoinTable(name="Movie_Director")
	@Cascade(value=(org.hibernate.annotations.CascadeType.ALL))
	private List<Director> director = new ArrayList<Director>();
	
	@ManyToMany
	@JoinTable(name="Movie_Artist")
	@Cascade(value=(org.hibernate.annotations.CascadeType.ALL))
	private List<Artist> artist = new ArrayList<Artist>();
	
	@ElementCollection
	@OrderColumn(name = "index_genere")
	@Enumerated(EnumType.STRING)
	private List<Genere> genere = new ArrayList<Genere>();
	
	@ElementCollection
	@OrderColumn(name="comment_index")
	private List<String> comment= new ArrayList<String>();
	
	public Movie()
	{
		super();
	}
	
	public Movie(String poster, String summary, String title, String year,Rating rating)
	{
		this.poster=poster;
		this.summary=summary;
		this.title=title;
		this.year=year;
		this.rating=rating;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public List<Director> getDirector() {
		return director;
	}

	public void setDirector(List<Director> director) {
		this.director = director;
	}

	public List<Artist> getArtist() {
		return artist;
	}

	public void setArtist(List<Artist> artist) {
		this.artist = artist;
	}

	public List<Genere> getGenere() {
		return genere;
	}

	public void setGenere(List<Genere> genere) {
		this.genere = genere;
	}

	public List<String> getComment() {
		return comment;
	}

	public void setComment(List<String> comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}
	
	
}
