package com.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.api.dao.BookDAO;
import com.api.entity.Book;
import java.util.List;



//import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.PathParam;


@Path("book")
public class Ressources {

	    @GET
	    @Path("/all")
	    @Produces("application/json")
	    public List<Book> getBook() {
	      BookDAO dao = new BookDAO();
	      List<Book> books = dao.getAllBooks();
	        return books;
	    }
	    
	    @GET
	    @Path("/get/{id}")
	    @Produces("application/json")
	    public Book getBookById(@PathParam("id") int id) {
	      BookDAO dao = new BookDAO();
	      Book Book = dao.getBookById(id);
	        return Book;
	    }

	
	    @POST
	    @Path("/create")
	    @Consumes("application/json")
	    public Response addBook(Book book){
	    	BookDAO dao = new BookDAO();
	    	book.setName(book.getName());
	    	book.setPrice(book.getPrice());
	    	book.setDescription(book.getDescription());     
	    dao.saveBook(book);
	    
	    return Response.ok().build();
	    }
	    
//	    
//	    @POST
//	    @Path("/create")
//	    @Consumes("application/json")
//	    public Response addBook(Book bk){
//	        bk.setName(bk.getName());
//	        bk.setPrice(bk.getPrice());
//	        bk.setDescription(bk.getDescription());     
//	        BookDAO dao = new BookDAO();
//	        dao.saveBook(bk);
//	        
//	        return Response.ok().build();
//	    }
	    
	    @PUT
	    @Path("/update/{id}")
	    @Consumes("application/json")
	    public Response updateEmployee(@PathParam("id") int id, Book book){
	      BookDAO dao = new BookDAO();
	    int count = dao.updateBook(id, book);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("l'operation a reussite").build();
	    }
	    
	    @DELETE
	    @Path("/delete/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response deleteBook(@PathParam("id") int id){
	      BookDAO dao = new BookDAO();
	    int count = dao.deleteBookById(id);
	    if(count==0){
	      return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok("Rows affected: ").build();
	    }
}

