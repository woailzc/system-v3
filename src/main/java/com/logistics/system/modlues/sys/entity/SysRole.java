package com.logistics.system.modlues.sys.entity;

import java.util.List;
import java.util.Set;

import com.logistics.system.common.baseEntity.DataEntity;
import com.logistics.system.modlues.shiroTest.entity.Permission;

public class SysRole extends DataEntity<SysRole> {

    private String name;
    
    private List<SysPermission> sysPermissions;

   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public List<SysPermission> getSysPermissions() {
		return sysPermissions;
	}

	public void setSysPermissions(List<SysPermission> sysPermissions) {
		this.sysPermissions = sysPermissions;
	}


    
}