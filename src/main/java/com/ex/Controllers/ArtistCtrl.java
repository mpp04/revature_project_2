package com.ex.Controllers;



import com.ex.Frames.Artists;
import com.ex.Services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistCtrl {
    private final ArtistService artistService;

    @Autowired
    public ArtistCtrl(ArtistService artistService) {
        this.artistService = artistService;
    }


    @GetMapping
    @ResponseBody
    public ResponseEntity<String> getAllArtists() {
        return new ResponseEntity(artistService.getAllArtists(), HttpStatus.OK);
    }

}
