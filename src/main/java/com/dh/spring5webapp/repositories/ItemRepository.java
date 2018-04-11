package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
