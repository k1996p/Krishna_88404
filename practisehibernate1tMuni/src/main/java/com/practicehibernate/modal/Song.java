package com.practicehibernate.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="song")
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="songName")
	private String songName;
	
	@Column(name="songType")
	private String songType;
	
	@OneToOne(mappedBy="song",cascade=CascadeType.ALL)
	//cascade type all except remove to only delete song not singer
	private Singer singer;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="songId")
	private List<Review> reviews;

	public Song() {
		super();
	}

	public Song(String songName, String songType) {
		super();
		this.songName = songName;
		this.songType = songType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongType() {
		return songType;
	}

	public void setSongType(String songType) {
		this.songType = songType;
	}

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void addReview(Review review) {
		if(reviews == null) {
			reviews = new ArrayList<>();
		}
		reviews.add(review);
	}
	
	
	@Override
	public String toString() {
		return "Song [id=" + id + ", songName=" + songName + ", songType=" + songType + "]";
	}
	
	
}
