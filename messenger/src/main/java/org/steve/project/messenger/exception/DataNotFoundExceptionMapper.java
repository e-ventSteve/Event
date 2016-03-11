package org.steve.project.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.steve.project.messenger.model.ErrorMessage;

@Provider // Registers the exception in JAX-RS
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "Not Found");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
