package com.ultimatedigitallabsactorms.services;

import com.ultimatedigitallabsactorms.models.Actor;
import com.ultimatedigitallabsactorms.models.MovieResponseModel;
import com.ultimatedigitallabsactorms.proxy.MovieProxy;
import com.ultimatedigitallabsactorms.repositories.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService{
    private final ActorRepository repository;
    private final MovieProxy movieProxy;
    @Override
    public List<Actor> getAll() {
        return repository.findAll();
    }

    @Override
    public Actor getActorById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Actor updateActor(Actor actor) {
        return repository.save(actor);
    }

    @Override
    public MovieResponseModel getMovieById(int id) {
        return movieProxy.getById(id);
    }
}
