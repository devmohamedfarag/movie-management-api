package com.movie.movieapi.mapper;

import com.movie.movieapi.dto.MovieDto;
import com.movie.movieapi.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface MovieMapper extends BaseMapper<Movie, MovieDto>{
}
