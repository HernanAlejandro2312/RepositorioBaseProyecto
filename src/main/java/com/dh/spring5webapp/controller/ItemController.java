/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/items")
public class ItemController {
    private ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @RequestMapping
    public String getItems(Model model) {
        model.addAttribute("items", service.findAll());
        return "items";
    }

    @RequestMapping("/{id}")
    public String getItemsById(@PathVariable("id") @NotNull Long id, Model model) {
        model.addAttribute("item", service.findById(id));
        return "item";
    }
}    