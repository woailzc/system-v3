package com.logistics.system.modlues.sys.entity;

import java.util.Date;

import com.logistics.system.common.baseEntity.DataEntity;

public class SysPermission extends DataEntity<SysPermission> {
  
    private String name;
    
    private SysMenu sysMenu;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public SysMenu getSysMenu() {
		return sysMenu;
	}

	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}
    
}