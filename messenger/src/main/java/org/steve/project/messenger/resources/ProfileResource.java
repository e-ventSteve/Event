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
import javax.ws.rs.core.MediaType;

import org.steve.project.messenger.model.Profile;
import org.steve.project.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles(){
		return profileService.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@GET
	@Path("/{profileID}")
	public Profile getProfile(@PathParam("profileID") long profileId){
		return profileService.getProfile(profileId);
	}
	
	@PUT
	@Path("/{profileID}")
	public Profile updateProfile(@PathParam("profileID") long profileID, Profile profile){
		profile.setID(profileID);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") long profileID){
		profileService.removeProfile(profileID);
	}
}
