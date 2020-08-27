package com.ex.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller // mark this been as a controller bean. it will receive requests from the DispatchServlet
@RequestMapping(path="/greetings") // this controller will be reached by request to /api/greetings/*
public class GreetingsController {
  private final List<String> motds = new ArrayList<>();
  private final Random randomGen = new Random();

  @PostConstruct
  protected void initializeMotds() {
    motds.addAll(Arrays.asList("Good Morning",
      "The first step of a journey is always the most difficult",
      "You always pass failure on your way to success",
      "It always seems impossible, until it is done",
      "Positive anything is always better than negative nothing"));
  }

  @GetMapping(produces= MediaType.TEXT_PLAIN_VALUE)  // Get request to /api/greetings/
  @ResponseBody
  public ResponseEntity<String> getMotd() {
    int index = randomGen.ints(0, motds.size()).findFirst().getAsInt();
    return new ResponseEntity<>(motds.get(index), HttpStatus.OK);
  }

  @PostMapping(consumes=MediaType.TEXT_PLAIN_VALUE) // Post request to /api/greetings/
                                                    // with a string in the body
  @ResponseBody
  public ResponseEntity<String> addMotd(@RequestBody String motdObject) throws URISyntaxException {
    if(motdObject == null) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    } else {
      motds.add(motdObject);
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.setLocation(new URI("http://localhost:8080/api/greetings/" + (motds.size()-1)));
      return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED );
    }
  }

  @GetMapping(path="{id}", produces=MediaType.TEXT_PLAIN_VALUE) // Get request to /api/greetings/x
                                                                // where x is some int
  @ResponseBody
  public ResponseEntity<String> getMotdById(@PathVariable int id) {
    if(id > motds.size() - 1 || id < 0) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(motds.get(id), HttpStatus.OK);
    }
  }

  public List<String> getMotds() {
    return motds;
  }
}
