/*package com.ex.Controllers;



import com.ex.Frames.Artists;
import com.ex.Services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ArtistCtrl {
    private final ArtistService artistService;

    @Autowired
    public ArtistCtrl(ArtistService artistService) {
        this.artistService = artistService;
    }
    @RequestMapping("/artists")
    public List<Artists> getAllArtists(){
        return artistService.getAllArtists();
    }

}*/
