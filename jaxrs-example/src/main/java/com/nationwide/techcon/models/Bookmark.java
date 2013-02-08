package com.nationwide.techcon.models;

import java.net.URI;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bookmark {
	
	private String name;
	private String url;
	private Date createDate;
	private URI location;
	
	public Bookmark() {
		this.createDate = new Date();
	}

	public Bookmark(String name, String url) {
		this();
		this.name = name;
		this.url = url;
	}
	
	@XmlElement(name="description")
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@XmlAttribute(name="time")
	public Date getCreateDate() {
		return new Date(this.createDate.getTime());
	}
	
	@XmlAttribute(name="href")
	public URI getLocation() {
		return this.location;
	}
	
	public void setLocation(URI location) {
		this.location = location;
	}
}
