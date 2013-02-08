package com.nationwide.techcon.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.nationwide.techcon.dao.BookmarkDAO;
import com.nationwide.techcon.models.Bookmark;
import com.nationwide.techcon.models.Bookmarks;

@Path("/bookmarks")
public class BookmarksResource {
	
	@Context
	private UriInfo uriInfo;

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Bookmarks getBookmarks() {
		return BookmarkDAO.instance.getBookmarks();
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response addBookmark(Bookmark bookmark) {
		URI location = BookmarkDAO.instance.addBookmark(bookmark, uriInfo);
		return Response.created(location).build();
	}
	
	@Path("{id}")
	public BookmarkResource getBookmarkResource(@PathParam("id") int id) {
		return new BookmarkResource(id);
	}
}
