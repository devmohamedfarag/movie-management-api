package com.movie.movieapi.service.Impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.movie.movieapi.Exception.ResourceNotFoundException;
import com.movie.movieapi.dto.MovieDto;
import com.movie.movieapi.mapper.MovieMapper;
import com.movie.movieapi.model.Movie;
import com.movie.movieapi.repository.MovieRepository;
import com.movie.movieapi.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieDto createMovie(MovieDto movieDto) {
        Movie movie = movieMapper.toEntity(movieDto);
        Movie savedMovie = movieRepository.save(movie);
        return movieMapper.toDto(savedMovie);
    }

    @Override
    public MovieDto getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id " + id));
        return movieMapper.toDto(movie);
    }

    @Override
    public void deleteMovieById(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Movie not found with id " + id);
        }
        movieRepository.deleteById(id);
    }

    @Override
    public List<MovieDto> searchMovieByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(movieMapper::toDto)
                .toList();
    }

    @Override
    public Page<MovieDto> getAllMovies(Pageable pageable) {
        return movieRepository.findAll(pageable)
                .map(movieMapper::toDto);
    }

}
