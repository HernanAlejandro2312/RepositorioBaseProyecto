/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.model.Item;
import com.dh.spring5webapp.model.SubCategory;
import com.dh.spring5webapp.services.ItemService;
import com.dh.spring5webapp.services.SubCategoryService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

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

    @RequestMapping(value = "/delete/{id}")
    public String deleteItem(Model model, @PathVariable String id) {
        service.deleteById(Long.valueOf(id));
        return "redirect:/items/";
    }

    @RequestMapping(value = "/{id}/image")
    public String showUploadItemImageForm(Model model, @PathVariable String id) {
        Item itemPersisted = service.findById(Long.valueOf(id));
        model.addAttribute("item", itemPersisted);
        return "uploadItemImageForm";
    }

    @PostMapping("/{id}/image")
    public String potImage(Model model, @PathVariable String id, @RequestParam("imagefile") MultipartFile file) {
        service.saveImage(Long.valueOf(id), file);

        model.addAttribute("item", service.findById(Long.valueOf(id)));
        model.addAttribute("subCategories", subCategoryService.findAll());
        return "redirect:/items/update/{id}";
    }

    @GetMapping("/{id}/readimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        Item itemPersisted = service.findById(Long.valueOf(id));

        if (itemPersisted.getImage() != null) {
            byte[] byteArray = new byte[itemPersisted.getImage().length];
            int i = 0;

            for (Byte wrappedByte : itemPersisted.getImage()) {
                byteArray[i++] = wrappedByte;
            }
            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }

}    