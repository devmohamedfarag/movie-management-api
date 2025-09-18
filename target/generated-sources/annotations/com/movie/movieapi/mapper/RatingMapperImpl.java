package com.movie.movieapi.mapper;

import com.movie.movieapi.dto.RatingDto;
import com.movie.movieapi.model.Rating;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-15T18:18:35+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class RatingMapperImpl implements RatingMapper {

    @Override
    public RatingDto toDto(Rating entity) {
        if ( entity == null ) {
            return null;
        }

        RatingDto.RatingDtoBuilder ratingDto = RatingDto.builder();

        ratingDto.score( entity.getScore() );

        return ratingDto.build();
    }

    @Override
    public Rating toEntity(RatingDto dto) {
        if ( dto == null ) {
            return null;
        }

        Rating.RatingBuilder rating = Rating.builder();

        rating.score( dto.getScore() );

        return rating.build();
    }

    @Override
    public List<RatingDto> toDtoList(List<Rating> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RatingDto> list = new ArrayList<RatingDto>( entities.size() );
        for ( Rating rating : entities ) {
            list.add( toDto( rating ) );
        }

        return list;
    }

    @Override
    public List<Rating> toEntityList(List<RatingDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Rating> list = new ArrayList<Rating>( dtos.size() );
        for ( RatingDto ratingDto : dtos ) {
            list.add( toEntity( ratingDto ) );
        }

        return list;
    }
}
