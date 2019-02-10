package com.logistics.system.modlues.sys.entity;

import java.util.List;

import com.logistics.system.common.baseEntity.DataEntity;
import com.logistics.system.modlues.shiroTest.entity.Permission;

public class SysMenu extends DataEntity<SysMenu>{
	
	private String menuName;
	
	private String url;
	
	private SysMenu fatherMenu;
	
	private List<SysMenu> sonMenu;
	
	private List<Permission> permissions;
	
	public SysMenu(){};
	
	public SysMenu(String id){
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public SysMenu getFatherMenu() {
		return fatherMenu;
	}

	public void setFatherMenu(SysMenu fatherMenu) {
		this.fatherMenu = fatherMenu;
	}

	public List<SysMenu> getSonMenu() {
		return sonMenu;
	}

	public void setSonMenu(List<SysMenu> sonMenu) {
		this.sonMenu = sonMenu;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	

}
