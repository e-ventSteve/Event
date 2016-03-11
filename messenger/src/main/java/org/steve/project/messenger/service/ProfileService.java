package org.steve.project.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.steve.project.messenger.database.DatabaseClass;
import org.steve.project.messenger.model.Profile;

public class ProfileService {
	
	private Map<Long, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put(1L, new Profile(1L, "SMAIT", "Steve", "Mail", "steve1877@hotmail.com", "M"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(long profileID){
		return profiles.get(profileID);
	}
	
	public Profile addProfile(Profile profile){
		profile.setID(profiles.size() + 1);
		return profiles.put(profile.getID(), profile);
	}

	
	public Profile updateProfile(Profile profile){
		if (profile.getID() <= 0){
			return null;
		}
		profiles.put(profile.getID(), profile);
		return profile;
	}
	
	public Profile removeProfile(long profileID){
		return profiles.remove(profileID);
	}
}
