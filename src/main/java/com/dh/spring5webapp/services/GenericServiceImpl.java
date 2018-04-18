/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public abstract class GenericServiceImpl<T> implements GenericService<T> {

    @Override
    public List<T> findAll() {
        List<T> results = new ArrayList<>();
        getRepository().findAll().forEach(results::add);
        return results;
    }

    @Override
    public T findById(Long id) {
        return getRepository().findById(id).get();
    }

    protected abstract CrudRepository<T, Long> getRepository();
}