/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.ws.api.photos.controllers;

import com.appsdeveloperblog.ws.api.photos.response.PhotoRest;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photos")
public class PhotosController {
    
    @GetMapping
    public List<PhotoRest> getPhotos() { 
        
        PhotoRest photo3 = new PhotoRest();
        photo3.setAlbumId("albumIdHere");
        photo3.setPhotoId("3");
        photo3.setUserId("3");
        photo3.setPhotoTitle("Photo 3 title");
        photo3.setPhotoDescription("Photo 3 description");
        photo3.setPhotoUrl("Photo 3 URL");
        
        PhotoRest photo4 = new PhotoRest();
        photo4.setAlbumId("albumIdHere");
        photo4.setPhotoId("4");
        photo4.setUserId("3");
        photo4.setPhotoTitle("Photo 4 title");
        photo4.setPhotoDescription("Photo 4 description");
        photo4.setPhotoUrl("Photo 4 URL"); 
         
        return Arrays.asList(photo3, photo4);
    }
 
}
