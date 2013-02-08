package com.nationwide.techcon.dao;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.core.UriInfo;

import com.nationwide.techcon.models.Bookmark;
import com.nationwide.techcon.models.Bookmarks;

public enum BookmarkDAO {

	instance;

	private Map<Integer, Bookmark> contentProvider = new HashMap<Integer, Bookmark>();
	private AtomicInteger sequence = new AtomicInteger(0);

	private BookmarkDAO() {
	}

	public Bookmarks getBookmarks() {
		Bookmarks bookmarks = new Bookmarks();
		for (Bookmark b : contentProvider.values()) {
			bookmarks.addBookmark(b);
		}
		return bookmarks;
	}

	public URI addBookmark(Bookmark bookmark, UriInfo uriInfo) {
		int id = sequence.incrementAndGet();
		bookmark.setLocation(uriInfo.getAbsolutePathBuilder().path("{id}")
				.build(id));
		contentProvider.put(id, bookmark);
		return bookmark.getLocation();
	}

	public Bookmark getBookmark(int id) {
		Bookmark bookmark = contentProvider.get(id);
		if (bookmark == null) {
			throw new IllegalArgumentException();
		}
		return bookmark;
	}
	
	public Bookmark updateBookmark(int id, Bookmark bookmark) {
		Bookmark old = contentProvider.get(id);
		if (old == null) {
			throw new IllegalArgumentException();
		}
		bookmark.setLocation(old.getLocation());
		contentProvider.put(id, bookmark);
		return bookmark;
	}
	
	public void deleteBookmark(int id) {
		if (contentProvider.remove(id) == null) {
			throw new IllegalArgumentException();
		}
	}
}
