
package com.ex.Controllers;

import com.ex.Frames.Albums;
import com.ex.Services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/albums")
public class AlbumCtrl {
    private final AlbumService albumService;

    @Autowired
    public AlbumCtrl(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> getAllAlbums(){
        return new ResponseEntity(albumService.getAllAlbums(),HttpStatus.OK);
    }

}

