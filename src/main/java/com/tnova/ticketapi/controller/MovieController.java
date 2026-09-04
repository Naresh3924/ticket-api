package com.tnova.ticketapi.controller;

import com.tnova.ticketapi.dto.MovieRequestDTO;
import com.tnova.ticketapi.dto.MovieResponseDTO;
import com.tnova.ticketapi.model.Movie;
import com.tnova.ticketapi.model.MovieRepository;
import com.tnova.ticketapi.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/movie")
    public ResponseEntity<MovieResponseDTO> createMovie(@Valid @RequestBody MovieRequestDTO request){
        MovieResponseDTO response=movieService.createMovie(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public  List<MovieResponseDTO> getAllMovie(){
        return  movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public MovieResponseDTO getMovieById(@PathVariable Long id){
        return movieService.getMovieByID(id);
    }

    @PutMapping("/{id}")
    public MovieResponseDTO updateMovieById(@PathVariable Long id, @Valid @RequestBody MovieRequestDTO request){
        return movieService.updateMovie(id,request);
    }
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

}