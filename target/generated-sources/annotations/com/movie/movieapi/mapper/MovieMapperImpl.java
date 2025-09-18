package com.movie.movieapi.mapper;

import com.movie.movieapi.dto.MovieDto;
import com.movie.movieapi.model.Movie;
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
public class MovieMapperImpl implements MovieMapper {

    @Override
    public MovieDto toDto(Movie entity) {
        if ( entity == null ) {
            return null;
        }

        MovieDto.MovieDtoBuilder movieDto = MovieDto.builder();

        movieDto.title( entity.getTitle() );
        movieDto.year( entity.getYear() );
        movieDto.type( entity.getType() );
        movieDto.director( entity.getDirector() );
        movieDto.actors( entity.getActors() );
        movieDto.poster( entity.getPoster() );
        movieDto.imdbId( entity.getImdbId() );

        return movieDto.build();
    }

    @Override
    public Movie toEntity(MovieDto dto) {
        if ( dto == null ) {
            return null;
        }

        Movie.MovieBuilder movie = Movie.builder();

        movie.title( dto.getTitle() );
        movie.year( dto.getYear() );
        movie.type( dto.getType() );
        movie.director( dto.getDirector() );
        movie.actors( dto.getActors() );
        movie.poster( dto.getPoster() );
        movie.imdbId( dto.getImdbId() );

        return movie.build();
    }

    @Override
    public List<MovieDto> toDtoList(List<Movie> entities) {
        if ( entities == null ) {
            return null;
        }

        List<MovieDto> list = new ArrayList<MovieDto>( entities.size() );
        for ( Movie movie : entities ) {
            list.add( toDto( movie ) );
        }

        return list;
    }

    @Override
    public List<Movie> toEntityList(List<MovieDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Movie> list = new ArrayList<Movie>( dtos.size() );
        for ( MovieDto movieDto : dtos ) {
            list.add( toEntity( movieDto ) );
        }

        return list;
    }
}
