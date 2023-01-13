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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "channel")
public class Channel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "channelName")
	private String channelName;

	@Column(name = "channelType")
	private String channelType;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "channel_subscriber", joinColumns = @JoinColumn(name = "channel_id"), inverseJoinColumns = @JoinColumn(name = "subscriber_id"))
	private List<Subscriber> subscribers;

	public Channel() {
		super();
	}

	public Channel(String channelName, String channelType) {
		super();
		this.channelName = channelName;
		this.channelType = channelType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public List<Subscriber> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(List<Subscriber> subscribers) {
		this.subscribers = subscribers;
	}

	public void addSubscriber(Subscriber subscriber) {

		if (subscribers == null) {
			subscribers = new ArrayList<>();
		}

		subscribers.add(subscriber);
	}

	@Override
	public String toString() {
		return "Channel [id=" + id + ", channelName=" + channelName + ", channelType=" + channelType + "]";
	}

	

}
