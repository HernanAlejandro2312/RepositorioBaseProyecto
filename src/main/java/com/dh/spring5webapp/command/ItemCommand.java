/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.Item;

public class ItemCommand {

    private String name;
    private String code;
    private String label;
    private String image;
    private String category;
    private Long subCategoryId;
    private String price;
    private Object[] comments = new Object[0];
    private Long id;
    private String description;
    private Boolean featured;

    public ItemCommand(Item item) {
        this.setCategory(item.getSubCategory().getCategory().getName());
        this.setDescription(item.getName());
        this.setFeatured(true);
        this.setId(item.getId());
        this.setName(item.getName());
        this.setLabel(item.getName());
        this.setImage("/assets/images/glasses.jpg");
        this.setPrice("5");
    }

    public ItemCommand() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Object[] getComments() {
        return comments;
    }

    public void setComments(Object[] comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Item toDomain() {
        Item item = new Item();
        item.setCode(getCode());
        item.setId(getId());
        item.setName(getName());
        return item;
    }
}
