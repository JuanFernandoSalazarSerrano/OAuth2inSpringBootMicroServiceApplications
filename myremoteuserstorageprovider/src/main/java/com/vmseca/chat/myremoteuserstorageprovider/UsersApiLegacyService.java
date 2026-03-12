package com.vmseca.chat.myremoteuserstorageprovider;

import org.keycloak.http.simple.SimpleHttp;
import org.keycloak.http.simple.SimpleHttpRequest;
import org.keycloak.models.KeycloakSession;

import jakarta.ws.rs.PathParam;

import org.jboss.logging.Logger;

public class UsersApiLegacyService {
    	
    private static final Logger LOGGER = Logger.getLogger(UsersApiLegacyService.class);

    private KeycloakSession session;

    public UsersApiLegacyService(KeycloakSession session){
        this.session = session;
    }

    public User getUserByUsername(String username) {
        try {
            SimpleHttp httpClient = SimpleHttp.create(session); // Use factory method with session
            User user = httpClient.doGet("http://localhost:8099/users/" + username).asJson(User.class);
            return user;
        } catch (Exception ex) {
            LOGGER.error("Error fetching user " + username + " from external service: " + ex.getMessage(), ex);
            return null; // Or handle differently, e.g., throw a custom exception
        }
    }

        public VerifyPasswordResponse verifyUserPassword(@PathParam("username") String username, String password) {
        
        // prepare post request to verify endpoint
        SimpleHttp httpClient = SimpleHttp.create(session); // Use factory method with session
        SimpleHttpRequest simpleHttp = httpClient.doPost("http://localhost:8099/users/" + username + "/verify-password");
        
        VerifyPasswordResponse verifyPasswordResponse = null;

        // Include password as form data in the request body
        simpleHttp.param("password", password);
        
        // Add headers if needed
        simpleHttp.header("Content-Type", "application/x-www-form-urlencoded");

        try {
            // send http post request and retrieve as json stream, convert it to VerifyPasswordResponse 
            verifyPasswordResponse = simpleHttp.asJson(VerifyPasswordResponse.class);
        } catch (Exception e) {
            LOGGER.error("The provided password is incorrect", e);
        }

        return verifyPasswordResponse;
    }
}
