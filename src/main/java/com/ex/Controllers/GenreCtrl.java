
package com.ex.Controllers;


import com.ex.Frames.Genres;
import com.ex.Services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/genres")
public class GenreCtrl {

    private final GenreService genreService;

    @Autowired
    public GenreCtrl(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> getAllGenres() {
        return new ResponseEntity(genreService.getAllGenres(), HttpStatus.OK);

    }
}

