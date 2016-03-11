package org.steve.project.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.steve.project.messenger.model.Message;
import org.steve.project.messenger.service.MessageService;
// Other params, Form, Cookie, Header Matrix JB14
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

		MessageService messageService = new MessageService();
		
		@GET
		public List<Message> getMessages(@QueryParam("year") int year,
										@QueryParam("start") int start,
										@QueryParam("size") int size){
			
//			if (year > 0){
//				return messageService.getAllMessagesForYear(year);
//			}
//			
//			if (start >= 0 && size >= 0){
//				return messageService.getAllMessagesPaginated(start, size);
//			}
			
			return  messageService.getAllMessages();
			
			
		}
		
		@POST
		public Response addMessage(Message message, @Context UriInfo uriInfo){
			Message newMessage = messageService.addMessage(message);
			String newId = String.valueOf(newMessage.getId());
			URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
			return Response.created(uri)
				.entity(newMessage)
				.build();
			
			//return messageService.addMessage(message);
		}
		
		@PUT
		@Path("/{messageID}")
		public Message updateMessage(@PathParam("messageID") Long id, Message message){
			message.setId(id);
			return messageService.updateMesasge(message);
		}
		
		@DELETE
		@Path("/{messageID}")
		public void deleteMessage(@PathParam("messageID") Long id){
			messageService.removeMessage(id);
		}
		
		@GET
		@Path("/{messageID}")
		public Message getMessage(@PathParam("messageID") Long id){
			return messageService.getMessage(id);
		}
		
		@Path("/{messageID}/comments")
		public CommentResource getCommentResource(){
			return new CommentResource();
		}
}
