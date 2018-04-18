/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.model.Item;
import com.dh.spring5webapp.repositories.ItemRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Item> implements ItemService {
    private ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<Item, Long> getRepository() {
        return repository;
    }
}