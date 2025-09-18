package com.movie.movieapi.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatingDto {

    private int score;

    private Long movieId;

    private Long userId;
}
