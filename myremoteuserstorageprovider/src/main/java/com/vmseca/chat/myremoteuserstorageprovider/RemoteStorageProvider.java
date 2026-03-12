package com.vmseca.chat.myremoteuserstorageprovider;

import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialInputValidator;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.user.UserLookupProvider;

public class RemoteStorageProvider implements UserStorageProvider, UserLookupProvider, CredentialInputValidator {

    KeycloakSession session;
    ComponentModel model;
    private UsersApiLegacyService usersService;

    public RemoteStorageProvider(KeycloakSession session, ComponentModel model, UsersApiLegacyService usersService) {
        super();
        this.session = session;
        this.model = model;
        this.usersService = usersService;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub        
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }

    @Override
    public UserModel getUserById(RealmModel realm, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public UserModel getUserByUsername(RealmModel realm, String username) {
        UserModel returnValue = null;
        User user = usersService.getUserByUsername(username);

        if (user != null) {
            returnValue = new UserAdapter(session, realm, model, user);
        }

        return returnValue;

    }

    @Override
    public UserModel getUserByEmail(RealmModel realm, String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserByEmail'");
    }

    @Override
    public boolean supportsCredentialType(String credentialType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'supportsCredentialType'");
    }

    @Override
    public boolean isConfiguredFor(RealmModel realm, UserModel user, String credentialType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isConfiguredFor'");
    }

    @Override
    public boolean isValid(RealmModel realm, UserModel user, CredentialInput credentialInput) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }

}
