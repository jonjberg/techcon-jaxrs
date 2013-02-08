package com.nationwide.techcon.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bookmarks {
	
	private List<Bookmark> bookmarks = new ArrayList<Bookmark>();
	
	public void addBookmark(Bookmark bookmark) {
		this.bookmarks.add(bookmark);
	}
	
	public void removeBookmark(Bookmark bookmark) {
		this.bookmarks.remove(bookmark);
	}
	
	@XmlElement(name="bookmark")
	public List<Bookmark> getBookmarks() {
		return this.bookmarks;
	}
}
