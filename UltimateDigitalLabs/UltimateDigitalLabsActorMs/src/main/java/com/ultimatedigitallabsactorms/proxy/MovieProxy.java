package com.ultimatedigitallabsactorms.proxy;

import com.ultimatedigitallabsactorms.models.MovieResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="movies-ms")
public interface MovieProxy {

    @GetMapping("/api/v1/movies/{id}")
    MovieResponseModel getById(@PathVariable int id);
}
