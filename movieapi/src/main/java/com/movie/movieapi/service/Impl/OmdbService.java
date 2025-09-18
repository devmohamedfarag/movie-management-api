package com.movie.movieapi.service.Impl;


import com.movie.movieapi.dto.OmdbDto.OmdbMovieByIdResponse;
import com.movie.movieapi.dto.OmdbDto.OmdbMovieResponse;
import com.movie.movieapi.dto.OmdbDto.OmdbSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OmdbService {

    private final WebClient webClient;

    @Value("${omdb.api.key}")
    private String apiKey;

    public List<OmdbMovieResponse> searchMovies(String title) {
        OmdbSearchResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("apikey", apiKey)
                        .queryParam("s", title)
                        .build())
                .retrieve()
                .bodyToMono(OmdbSearchResponse.class)
                .block();

        if (response == null || response.getSearch() == null) {
            throw new RuntimeException("No movies found: " + (response != null ? response.getError() : "null response"));
        }
        return response.getSearch();
    }

    public OmdbMovieByIdResponse getMovieByImdbId(String imdbId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("apikey", apiKey)
                        .queryParam("i", imdbId)
                        .build())
                .retrieve()
                .bodyToMono(OmdbMovieByIdResponse.class)
                .block();
    }
}
