package com.ex.Controllers;



import com.ex.Frames.Artists;
import com.ex.Services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


public class ArtistCtrl {
    @Autowired
    private ArtistService artistService;
    @RequestMapping("/artists")
    public List<Artists> getAllArtists(){
        return artistService.getAllArtists();
    }

}
