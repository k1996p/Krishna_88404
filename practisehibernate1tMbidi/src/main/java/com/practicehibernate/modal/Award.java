package com.practicehibernate.modal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "award")
public class Award {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "awardName")
	private String awardName;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "singerId")
	private Singer singer;

	public Award() {
		super();
	}

	public Award(String awardName) {
		super();
		this.awardName = awardName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return "Award [id=" + id + ", awardName=" + awardName + "]";
	}

}
