package com.tnova.ticketapi.service;

import com.tnova.ticketapi.dto.MovieRequestDTO;
import com.tnova.ticketapi.dto.MovieResponseDTO;
import com.tnova.ticketapi.model.Movie;
import com.tnova.ticketapi.model.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    private MovieResponseDTO toResponseDTO(Movie movie){
        MovieResponseDTO dto=new MovieResponseDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setRating(movie.getRating());
        dto.setReleaseYear(movie.getReleaseYear());
        return  dto;
    }

    public MovieResponseDTO createMovie(MovieRequestDTO request){
        Movie movie = new Movie(request.getTitle(),request.getRating(),request.getReleaseYear());
        return toResponseDTO(movieRepository.save(movie));
    }
    public List<MovieResponseDTO> getAllMovies(){
        return  movieRepository.findAll().stream()
                .map(this:: toResponseDTO)
                .collect(Collectors.toList());
    }
    public MovieResponseDTO getMovieByID(Long id){
        Movie movie=movieRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("movie not found"));
        return toResponseDTO(movie);
    }

    public MovieResponseDTO updateMovie(Long id,MovieRequestDTO request){
        Movie existing=movieRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("id not found"));

        existing.setTitle(request.getTitle());
        existing.setRating(request.getRating());
        existing.setReleaseYear(request.getReleaseYear());

        return toResponseDTO(movieRepository.save(existing));
    }

    public  void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }

}