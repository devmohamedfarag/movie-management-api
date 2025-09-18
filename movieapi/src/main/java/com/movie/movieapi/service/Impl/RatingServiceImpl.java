package com.movie.movieapi.service.Impl;


import com.movie.movieapi.Exception.ResourceNotFoundException;
import com.movie.movieapi.dto.RatingDto;
import com.movie.movieapi.dto.RatingResponseDto;
import com.movie.movieapi.model.Movie;
import com.movie.movieapi.model.Rating;
import com.movie.movieapi.model.User;
import com.movie.movieapi.repository.MovieRepository;
import com.movie.movieapi.repository.RatingRepository;
import com.movie.movieapi.repository.UserRepository;
import com.movie.movieapi.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    @Override
    public RatingResponseDto addRating(RatingDto request) {
        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Rating rating = Rating.builder()
                .score(request.getScore())
                .movie(movie)
                .user(user)
                .build();

        Rating saved = ratingRepository.save(rating);

        return RatingResponseDto.builder()
                .score(saved.getScore())
                .movieTitle(movie.getTitle())
                .username(user.getUsername())
                .build();
    }

    @Override
    public List<RatingResponseDto> getRatingsForMovie(Long movieId) {
        return ratingRepository.findByMovieId(movieId)
                .stream()
                .map(r -> RatingResponseDto.builder()
                        .score(r.getScore())
                        .movieTitle(r.getMovie().getTitle())
                        .username(r.getUser().getUsername())
                        .build())
                .toList();
    }
}



