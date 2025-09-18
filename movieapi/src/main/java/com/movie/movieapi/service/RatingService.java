package com.movie.movieapi.service;

import com.movie.movieapi.dto.RatingDto;
import com.movie.movieapi.dto.RatingResponseDto;

import java.util.List;

public interface RatingService {

    RatingResponseDto addRating(RatingDto request);

    List<RatingResponseDto> getRatingsForMovie(Long movieId);
}
