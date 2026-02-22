package com.appsdeveloperblog.PhotoAppWebClient.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.appsdeveloperblog.PhotoAppWebClient.response.AlbumRest;

@Controller
public class AlbumsController {

    // create an oauth2ClientService object to interact with the access token 
	@Autowired
	OAuth2AuthorizedClientService oauth2ClientService;

    @GetMapping("/albumsjava")
    public String getAlbums(Model model,
        // @AuthenticationPrincipal injects the principal in its specified implementation in this case, open id connect
         @AuthenticationPrincipal OidcUser principal) { 

		// use securitycontextholder to access the security context and obtain the access token to identify the currently authenticated user 
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        
        // cast the abstract authentication access token to an especific implementation, in this case outh2 (could be, okta, google, facebook, etc) 
		OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
		
        // this will be used to authorize this client object with the access token and the username
		OAuth2AuthorizedClient oauth2Client = oauth2ClientService.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(), 
				oauthToken.getName());
		
        // gettoken value returns an string to display it with sout
		String jwtAccessToken = oauth2Client.getAccessToken().getTokenValue();
		System.out.println("jwtAccessToken = " + jwtAccessToken);
		
		
		System.out.println("Principal = " + principal);
		
		OidcIdToken idToken = principal.getIdToken();
		String idTokenValue = idToken.getTokenValue();
		System.out.println("idTokenValue = " + idTokenValue);


        AlbumRest album = new AlbumRest();
        album.setAlbumId("albumone");
        album.setAlbumTitle("album one title");
        album.setAlbumUrl("http://localhost:8082/albums/1");

        AlbumRest album2 = new AlbumRest();
        album2.setAlbumId("albumtwo");
        album2.setAlbumTitle("album two title");
        album2.setAlbumUrl("http://localhost:8082/albums/2");

        List returnValue = Arrays.asList(album, album2);

        model.addAttribute("albums", returnValue);
        
        return "albums";

    }

}