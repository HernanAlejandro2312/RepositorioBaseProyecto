/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.dh.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class SubCategory extends ModelBase {
    private String name;
    private String code;
    @OneToOne(optional = false)
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
