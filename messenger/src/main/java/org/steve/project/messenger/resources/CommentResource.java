package org.steve.project.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.steve.project.messenger.model.Message;
import org.steve.project.messenger.service.MessageService;

@Path("/")//Inferred from MessageResource
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	
	@GET
	public String test(){
		return "new sub resource";
	}
	
	@GET
	@Path("/{commentID}")
	public String test2(@PathParam("messageId") long messageID, @PathParam("commentID") long commentID){
		return "Bastards" + commentID + messageID;
	}
}
