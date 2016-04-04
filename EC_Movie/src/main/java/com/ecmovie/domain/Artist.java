package com.ecmovie.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Artist implements Serializable{
	@Id  @GeneratedValue
	@Column(name="artist_Id")
	private int Id;
	private String name;
	private String DOB;
	private String POB;
	private String biography;
	@OneToMany (mappedBy="artist") 
/*	@JoinTable
	(
		      name="Artist_Picture",
		      joinColumns={ @JoinColumn(name="artist_id", referencedColumnName="artist_id") },
		      inverseJoinColumns={ @JoinColumn(name="pic_id", referencedColumnName="pic_id", unique=true) }
		  )
*/	private List<Picture> picture = new ArrayList<Picture>();
	
	@ManyToMany(mappedBy="artist")
	private List<Movie> movies = new ArrayList<Movie>();

	public Artist()
	{
		super();
	}
	
	public Artist(String name, String DOB, String POB, String biography)//, List<Picture> pic)
	{
		this.name=name;
		this.DOB=DOB;
		this.POB=POB;
		this.biography=biography;
//		this.picture=pic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getPOB() {
		return POB;
	}

	public void setPOB(String pOB) {
		POB = pOB;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<Picture> getPicture() {
		return picture;
	}

	public void setPicture(List<Picture> picture) {
		this.picture = picture;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public int getArtist_Id() {
		return Id;
	}
	
	public void addPicture(Picture p)
	{
		if(picture.contains(p))
		{
			picture.add(p);
		}
	}
	
}
