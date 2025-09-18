package com.movie.movieapi.mapper;

import com.movie.movieapi.dto.RatingDto;
import com.movie.movieapi.model.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface RatingMapper extends BaseMapper<Rating, RatingDto>{
}
