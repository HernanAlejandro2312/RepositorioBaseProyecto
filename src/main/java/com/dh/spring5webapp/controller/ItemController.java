/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.model.Item;
import com.dh.spring5webapp.model.SubCategory;
import com.dh.spring5webapp.services.ItemService;
import com.dh.spring5webapp.services.SubCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/items")
public class ItemController {
    private ItemService service;
    private SubCategoryService subCategoryService;

    public ItemController(ItemService service, SubCategoryService subCategoryService) {
        this.service = service;
        this.subCategoryService = subCategoryService;
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

    @RequestMapping("/new")
    public String newItem(Model model, Item item) {
        Item newItem = new Item();
        newItem.setSubCategory(new SubCategory());
        model.addAttribute("item", newItem);
        model.addAttribute("subCategories", subCategoryService.findAll());
        return "itemForm";
    }

    @PostMapping
    public String saveItem(Model model, Item item) {
        Item itemPersisted = service.save(item);
        model.addAttribute("item", itemPersisted);
        return "redirect:/items/" + itemPersisted.getId();
    }

    @RequestMapping("/update/{id}")
    public String updateItem(Model model, @PathVariable String id) {
        model.addAttribute("item", service.findById(Long.valueOf(id)));
        model.addAttribute("subCategories", subCategoryService.findAll());
        return "itemForm";
    }
}    