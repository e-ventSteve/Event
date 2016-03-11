package org.steve.project.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.steve.project.messenger.database.DatabaseClass;
import org.steve.project.messenger.exception.DataNotFoundException;
import org.steve.project.messenger.model.Message;


public class MessageService {
	// Ici il faudrait en fait chercher la base de données pour
	// les infos...

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	
	public MessageService(){
		messages.put(1L, new Message(1, "Hello World!", "Steve"));
		messages.put(2L, new Message(2, "Bonjour!", "Steve"));
		
	}
		
	public List<Message> getAllMessages() {			
		return new ArrayList<Message>(messages.values());
		//return getAllMessagesForYear(2016);
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()){
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<>(messages.values());
		
		return list.subList(start,  start + size);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMesasge(Message message){
		if (message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	
	public Message getMessage(Long id){
		Message message = messages.get(id);
		if (message == null){
			throw new DataNotFoundException("Message with ID " + id + " not found.");
		}
		return message;
	}
	
}
