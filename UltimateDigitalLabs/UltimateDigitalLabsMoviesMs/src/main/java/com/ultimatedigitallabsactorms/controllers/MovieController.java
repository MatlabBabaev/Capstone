package com.ultimatedigitallabsactorms.controllers;

import com.ultimatedigitallabsactorms.dto.MovieRequestDto;
import com.ultimatedigitallabsactorms.models.Movie;
import com.ultimatedigitallabsactorms.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService service;

    @GetMapping
    public List<Movie> getAll(){
        List<Movie> all = service.getAll();
        return all;
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable int id) {
        Movie byId = service.getById(id);
        return byId;
    }
//
//    @GetMapping("/{title}")
//    public Movie getByTitle(@PathVariable String title) throws Exception {
//        Movie byTitle = service.getByTitle(title);
//        return byTitle;
//    }
//
//    @PostMapping()
//    public Movie createMovie(@RequestBody MovieRequestDto dto) throws Exception {
//        Movie movie = service.createMovie(dto);
//        return movie;
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteMovie(@PathVariable int id) throws Exception {
//        String result = service.deleteMovie(id);
//        return result;
//    }
//
//    @PutMapping()
//    public Movie updateMovie(@RequestBody Movie movie){
//        Movie result = service.updateMovie(movie);
//        return result;
//    }
}
