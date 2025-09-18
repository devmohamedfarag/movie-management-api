package com.movie.movieapi.dto.OmdbDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatingOmdbDto {

        @JsonProperty("Source")
        private String source;

        @JsonProperty("Value")
        private String value;


}
