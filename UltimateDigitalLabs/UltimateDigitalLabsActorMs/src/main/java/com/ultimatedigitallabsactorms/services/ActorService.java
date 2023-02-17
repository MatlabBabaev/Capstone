package com.ultimatedigitallabsactorms.services;
import com.ultimatedigitallabsactorms.models.Actor;
import com.ultimatedigitallabsactorms.models.MovieResponseModel;

import java.util.List;

public interface ActorService {

    List<Actor> getAll();
    Actor getActorById(int id);

    Actor updateActor(Actor actor);

    MovieResponseModel getMovieById(int id);
}
