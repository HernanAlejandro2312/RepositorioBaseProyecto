/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.model.Category;

import java.util.List;

public interface CategoryService extends GenericService<Category> {
    List<Category> find(String code);
}
