package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Long> {
}
