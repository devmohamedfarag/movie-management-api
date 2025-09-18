package com.movie.movieapi.controller;

import com.movie.movieapi.dto.OmdbDto.OmdbMovieByIdResponse;
import com.movie.movieapi.dto.OmdbDto.OmdbMovieResponse;
import com.movie.movieapi.service.Impl.OmdbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/omdb")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class OmdbController {

    private final OmdbService omdbService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/search")
    public ResponseEntity<List<OmdbMovieResponse>> searchMovies(@RequestParam String title) {
        return ResponseEntity.ok(omdbService.searchMovies(title));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{imdbId}")
    public ResponseEntity<OmdbMovieByIdResponse> getMovieByImdbId(@PathVariable String imdbId) {
        return ResponseEntity.ok(omdbService.getMovieByImdbId(imdbId));
    }
}


