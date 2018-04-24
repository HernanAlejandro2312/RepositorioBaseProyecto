/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.model.Item;

import java.io.InputStream;

public interface ItemService extends GenericService<Item> {
    void saveImage(Long id, InputStream file);
}