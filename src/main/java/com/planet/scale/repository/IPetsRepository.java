package com.planet.scale.repository;

import com.planet.scale.model.Pets;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPetsRepository extends CrudRepository<Pets, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM pets")
    List<Pets> getPetsReport(); //TODO return lts pets
}
