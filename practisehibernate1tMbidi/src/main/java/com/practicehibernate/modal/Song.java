package com.practicehibernate.modal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@Override
	public String toString() {
		return "Song [id=" + id + ", songName=" + songName + ", songType=" + songType + "]";
	}
	
	
}
