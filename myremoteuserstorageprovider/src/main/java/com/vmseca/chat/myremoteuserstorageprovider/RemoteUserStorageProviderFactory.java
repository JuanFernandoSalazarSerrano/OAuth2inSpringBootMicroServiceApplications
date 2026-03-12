package com.vmseca.chat.myremoteuserstorageprovider;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.UserStorageProviderFactory;

public class RemoteUserStorageProviderFactory implements UserStorageProviderFactory<RemoteStorageProvider> {

    public static final String PROVIDER_NAME = "my-remote-mysql-user-storage-provider";

    @Override
    public RemoteStorageProvider create(KeycloakSession session, ComponentModel model) {
        
        return new RemoteStorageProvider(session, model);
    }

    @Override
    public String getId() {
        return PROVIDER_NAME;
    }

}
