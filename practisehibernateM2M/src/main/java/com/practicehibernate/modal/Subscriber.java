package com.practicehibernate.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subcriber")
public class Subscriber {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "fName")
	private String fName;

	@Column(name = "lName")
	private String lName;

	@Column(name = "subAge")
	private int subAge;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "channel_subscriber", joinColumns = @JoinColumn(name = "subscriber_id"), inverseJoinColumns = @JoinColumn(name = "channel_id"))
	private List<Channel> channels;

	public Subscriber() {
		super();
	}

	public Subscriber(String fName, String lName, int subAge) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.subAge = subAge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getSubAge() {
		return subAge;
	}

	public void setSubAge(int subAge) {
		this.subAge = subAge;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	@Override
	public String toString() {
		return "Subscriber [id=" + id + ", fName=" + fName + ", lName=" + lName + ", subAge=" + subAge + "]";
	}

	

}
