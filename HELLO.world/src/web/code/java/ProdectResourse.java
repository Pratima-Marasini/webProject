package web.code.java;

import java.awt.PageAttributes.MediaType;
import java.net.*;
import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.ws.Response;

@Path("/Prodects")

public class ProdectResourse {
	
	public class ProductResource {
	    private ProductDAO dao = ProductDAO.getInstance();
	     
	    @GET
	    @Produces(MediaType.Application_JSON)
	    public List<Product> list() {
	        return dao.listAll();
	    }
	    
	    @Post
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response add(Product product) throws URISyntaxException {
	        int newProductId = dao.add(product);
	        URI uri = new URI("/products/" + newProductId);
	        
	        return Response.created(uri).build();
	    }
	    
	    @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Path("{id}")
	    public Response update(@PathParam("id") int id, Product product) {
	        product.setId(id);
	        if (dao.update(product)) {
	            return Response.ok().build();
	        } else {
	            return Response.notModified().build();
	        }
	    }
	    @DELETE
	    @Path("{id}")
	    public Response delete(@PathParam("id") int id) {
	        if (dao.delete(id)) {
	            return Response.ok().build();
	        } else {
	            return Response.notModified().build();
	        }
	    }
	}

}
