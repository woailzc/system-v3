package com.logistics.system.modlues.ctn.entity;

import java.util.Date;

import com.logistics.system.common.baseEntity.DataEntity;

public class CtnFoodType extends DataEntity<CtnFoodType> {


    private String name;

  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}