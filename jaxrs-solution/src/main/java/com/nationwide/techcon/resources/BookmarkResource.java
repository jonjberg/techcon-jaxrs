package com.nationwide.techcon.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nationwide.techcon.dao.BookmarkDAO;
import com.nationwide.techcon.models.Bookmark;

public class BookmarkResource {

	private int id;
	
	public BookmarkResource(int id) {
		this.id = id;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Bookmark getBookmark() {
		try {
			return BookmarkDAO.instance.getBookmark(id);
		} catch (IllegalArgumentException e) {
			throw new WebApplicationException(e, Response.Status.NOT_FOUND);
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Bookmark updateBookmark(Bookmark bookmark) {
		try {
			return BookmarkDAO.instance.updateBookmark(id, bookmark);
		} catch (IllegalArgumentException e) {
			throw new WebApplicationException(e, Response.Status.NOT_FOUND);
		}
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void deleteBookmark() {
		try {
			BookmarkDAO.instance.deleteBookmark(id);
		} catch (IllegalArgumentException e) {
			throw new WebApplicationException(e, Response.Status.NOT_FOUND);
		}
	}
}
