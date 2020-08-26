package com.ex.Controllers;

import com.ex.Frames.Albums;
import com.ex.Services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AlbumCtrl {
    private final AlbumService albumService;

    @Autowired
    public AlbumCtrl(AlbumService albumService) {
        this.albumService = albumService;
    }

    @RequestMapping("/albums")
    public List<Albums> getAllAlbums(){
        return albumService.getAllAlbums();
    }

}
