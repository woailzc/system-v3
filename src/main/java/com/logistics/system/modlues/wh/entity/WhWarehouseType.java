package com.logistics.system.modlues.wh.entity;

import java.util.Date;

import com.logistics.system.common.baseEntity.DataEntity;

public class WhWarehouseType extends DataEntity<WhWarehouseType> {

    private String name;

    public String getName() {
        return name;
    }
    
    public WhWarehouseType(){};
    
    public WhWarehouseType(String id){
    	this.id = id;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}