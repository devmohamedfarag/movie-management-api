package com.movie.movieapi.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatingResponseDto {

    private int score;

    private String movieTitle;

    private String username;

}
