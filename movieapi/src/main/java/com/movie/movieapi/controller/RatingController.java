package com.movie.movieapi.controller;

import com.movie.movieapi.dto.RatingDto;
import com.movie.movieapi.dto.RatingResponseDto;
import com.movie.movieapi.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @PostMapping
    public ResponseEntity<RatingResponseDto> addRating(@RequestBody RatingDto request) {
        return ResponseEntity.ok(ratingService.addRating(request));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<RatingResponseDto>> getRatingsForMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok(ratingService.getRatingsForMovie(movieId));
    }
}
