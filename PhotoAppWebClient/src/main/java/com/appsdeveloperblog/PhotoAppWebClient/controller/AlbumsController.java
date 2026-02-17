package com.appsdeveloperblog.PhotoAppWebClient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumsController {

    @GetMapping("/albumsjava")
    public String getAlbums(Model model) {
        
        return "albums";

    }

}
