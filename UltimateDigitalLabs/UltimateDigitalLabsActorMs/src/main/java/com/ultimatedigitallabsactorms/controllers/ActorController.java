package com.ultimatedigitallabsactorms.controllers;

import com.ultimatedigitallabsactorms.models.Actor;
import com.ultimatedigitallabsactorms.models.MovieResponseModel;
import com.ultimatedigitallabsactorms.services.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/actors")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService service;

    @GetMapping
    public List<Actor> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Actor getActor(@PathVariable int id){
        return service.getActorById(id);
    }

    @PutMapping()
    public ResponseEntity<Actor> saveActor(@RequestBody Actor actor){
         return new ResponseEntity<>(service.updateActor(actor), HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public MovieResponseModel getMovie(@PathVariable int id){
        return service.getMovieById(id);
    }

}
