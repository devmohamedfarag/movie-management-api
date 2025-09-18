package com.movie.movieapi.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDto {

    private String title;

    private int year;

    private String type;

    private String director;

    private String actors;

    private String poster;

    private String imdbId;
}
