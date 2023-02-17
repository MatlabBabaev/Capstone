package com.ultimatedigitallabsactorms.services;

import com.ultimatedigitallabsactorms.dto.MovieRequestDto;
import com.ultimatedigitallabsactorms.models.Movie;
import com.ultimatedigitallabsactorms.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@Transactional
public class MovieServiceImpl implements MovieService{

    private final MovieRepository repository;

    @Override
    public List<Movie> getAll() {
        return repository.findAll();
    }

    @Override
    public Movie getById(int id) {
        Optional<Movie> byId = repository.findMovieByMovieId(id);
//        if(byId.isEmpty()){
//            throw new Exception("Not found");
//        }
        return byId.get();
    }

    @Override
    public Movie getByTitle(String title) throws Exception {
        Optional<Movie> byTitle = repository.findByMovieTitle(title);
        if(byTitle.isEmpty()){
            throw new Exception("Not found");
        }
        return byTitle.get();
    }

    @Override
    public Movie createMovie(MovieRequestDto dto) throws Exception {

        Optional<Movie> byMovieTitle = repository.findByMovieTitle(dto.getMovieTitle());
        if(byMovieTitle.isPresent()){
            throw new Exception("Already exist");
        }
        Movie movie = Movie.builder()
                .movieTitle(dto.getMovieTitle())
                .movieCost(dto.getMovieCost())
                .movieYear(dto.getMovieYear())
                .build();
        return repository.save(movie);
    }

    @Override
    public String deleteMovie(int id) throws Exception {

        Optional<Movie> byId = repository.findById(id);
        if(byId.isEmpty()){
            throw new Exception("Not found");
        }
        repository.deleteById(id);

        return "Movie deleted";
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return null;
    }

    @Override
    public List<Movie> getMoviesByIds(List<Integer> movieIds) {
        return null;
    }

}
