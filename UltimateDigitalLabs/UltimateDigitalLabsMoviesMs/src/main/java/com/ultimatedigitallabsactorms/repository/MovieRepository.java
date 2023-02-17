package com.ultimatedigitallabsactorms.repository;

import com.ultimatedigitallabsactorms.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Optional<Movie> findMovieByMovieId(int id);
    Optional<Movie> findByMovieTitle(String title);

    Optional<List<Movie>> findMoviesByMovieIdIn(List<Integer> Ids);
}

