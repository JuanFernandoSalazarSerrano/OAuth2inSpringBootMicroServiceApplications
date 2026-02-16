package com.appsdeveloper.ws.api.ResourceServer;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.appsdeveloper.ws.api.ResourceServer.pkce.PkceUtil;


@SpringBootApplication
public class ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
		// PkceUtil PkceUtilObject = new PkceUtil();
		// String verifieString;
		// try {

		// 	verifieString = PkceUtilObject.generateCodeVerifier();
		// 	System.out.println(verifieString + " verifier");
		// 	System.out.println(PkceUtilObject.generateCodeChallenge(verifieString) + " challenge");

		// } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		// }
	}

}
