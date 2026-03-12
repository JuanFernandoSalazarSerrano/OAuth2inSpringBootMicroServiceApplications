package com.vmseca.chat.myremoteuserstorageprovider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.keycloak.component.ComponentModel;
import org.keycloak.credential.UserCredentialManager;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.SubjectCredentialManager;
import org.keycloak.models.UserModel;
import org.keycloak.storage.adapter.AbstractUserAdapter;

import jakarta.ws.rs.core.MultivaluedHashMap;

public class UserAdapter extends AbstractUserAdapter {
	
	private final User user;
	
    // session provides access to keycloack, realm represent keycloack realm where the user belongs
    // storageProviderModel represent config of custom storage provider within keycloack
    // user instance of user class fetched from remote server (or local idk)

	public UserAdapter(KeycloakSession session, RealmModel realm, ComponentModel storageProviderModel, User user) {
		super(session, realm, storageProviderModel);
		this.user = user;
	}

	@Override
	public String getUsername() {
		return user.getEmail(); // email address as username
	}
	
	@Override
	public String getFirstName() {
		return user.getFirstName();
	}
	
	@Override
	public String getLastName() {
		return user.getLastName();
	}
	
	@Override
	public String getEmail() {
		return user.getEmail();
	}

    // return subject credential manager instance that
    // is responsible for manage user credentials within keycloack
	@Override
	public SubjectCredentialManager credentialManager() {
		return new UserCredentialManager(session, realm, this);
	}
	
    @Override
    public String getFirstAttribute(String name) {
        List<String> list = getAttributes().getOrDefault(name, new ArrayList<>());
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        MultivaluedHashMap<String, String> attributes = new MultivaluedHashMap<>();
        attributes.add(UserModel.USERNAME, getUsername());
        attributes.add(UserModel.EMAIL, getEmail());
        attributes.add(UserModel.FIRST_NAME, getFirstName());
        attributes.add(UserModel.LAST_NAME, getLastName());
        return attributes;
    }

}