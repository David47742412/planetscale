package com.planet.scale.repository;

import com.planet.scale.model.Pets;
import org.springframework.data.repository.CrudRepository;

public interface IPetsRepository extends CrudRepository<Pets, Integer> {
}
