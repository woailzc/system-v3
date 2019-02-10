package com.logistics.system.modlues.nt.entity;

import java.util.Date;

import com.logistics.system.common.baseEntity.DataEntity;

public class NtNoticeType extends DataEntity<NtNoticeType> {
  

    private String name;
    
    public NtNoticeType(){};
    
    public NtNoticeType(String id){
    	this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}