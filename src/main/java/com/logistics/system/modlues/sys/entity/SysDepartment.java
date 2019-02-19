package com.logistics.system.modlues.sys.entity;

import com.logistics.system.common.baseEntity.DataEntity;

public class SysDepartment extends DataEntity<SysDepartment> {
	
	private String name;
	
	public SysDepartment(){}
	
	public SysDepartment(String id){
		this.id = id;
	}
	
	public SysDepartment(String id, String name){
		this.id = id;
		this.name = name;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
