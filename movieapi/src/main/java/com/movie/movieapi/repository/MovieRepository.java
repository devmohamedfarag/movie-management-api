package com.movie.movieapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.movie.movieapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitleContainingIgnoreCase(String title);


}
