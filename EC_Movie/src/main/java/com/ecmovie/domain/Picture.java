package com.ecmovie.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Picture implements Serializable{


	@Id @GeneratedValue
	@Column(name="pic_id") 
	private int id;
	@Lob 
	private byte[] pic;
	
	@ManyToOne 
	@JoinColumn(name="artist_id")
	private Artist artist;
	
	public Picture()
	{
		super();
	}

	public Picture(byte[] pic)
	{
		this.pic=pic;
	}

	public int getPic_id() {
		return id;
	}


	public void setPic_id(int pic_id) {
		this.id = pic_id;
	}


	public byte[] getPic() {
		return pic;
	}


	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

    
}
