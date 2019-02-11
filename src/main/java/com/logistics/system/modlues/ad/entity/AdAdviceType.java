package com.logistics.system.modlues.ad.entity;

import java.util.Date;

import com.logistics.system.common.baseEntity.DataEntity;

public class AdAdviceType extends DataEntity<AdAdviceType> {

    private String name;

    
    public AdAdviceType(){};
    
    public AdAdviceType(String id){
    	this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}