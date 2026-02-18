package com.appsdeveloperblog.PhotoAppWebClient.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.appsdeveloperblog.PhotoAppWebClient.response.AlbumRest;

@Controller
public class AlbumsController {

    @GetMapping("/albumsjava")
    public String getAlbums(Model model) {

        AlbumRest album = new AlbumRest();
        album.setAlbumId("albumone");
        album.setalbumTitle("album one title");
        album.setalbumUrl("http://localhost:8082/albums/1");

        AlbumRest album2 = new AlbumRest();
        album.setAlbumId("albumtwo");
        album.setalbumTitle("album two title");
        album.setalbumUrl("http://localhost:8082/albums/2");

        List returnValue = Arrays.asList(album, album2);

        model.addAttribute("albums", returnValue);
        
        return "albums";

    }

}
