package com.movie.movieapi.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import com.movie.movieapi.dto.MovieDto;

import java.util.List;


public interface MovieService {

    MovieDto createMovie(MovieDto movieDto);

    MovieDto getMovieById(Long id);

    void deleteMovieById(Long id);

    List<MovieDto> searchMovieByTitle(String title);

   Page<MovieDto> getAllMovies(Pageable pageable);
}
