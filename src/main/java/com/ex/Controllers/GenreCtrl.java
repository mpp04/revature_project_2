package com.ex.Controllers;


import com.ex.Frames.Genres;
import com.ex.Services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class GenreCtrl {

    private final GenreService genreService;

    @Autowired
    public GenreCtrl(GenreService genreService) {
        this.genreService = genreService;
    }

    @RequestMapping("/genres")
    public List<Genres> getAllGenres(){
        return genreService.getAllGenres();
    }

}
