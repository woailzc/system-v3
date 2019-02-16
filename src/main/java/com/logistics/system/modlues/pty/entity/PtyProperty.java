package com.logistics.system.modlues.pty.entity;

import com.logistics.system.common.baseEntity.DataEntity;

public class PtyProperty extends DataEntity<PtyProperty> {
	
	private String name;
	
	private PtyPropertyType ptyPropertyType;

	public PtyProperty(String name, PtyPropertyType ptyPropertyType) {
		super();
		this.name = name;
		this.ptyPropertyType = ptyPropertyType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PtyPropertyType getPtyPropertyType() {
		return ptyPropertyType;
	}

	public void setPtyPropertyType(PtyPropertyType ptyPropertyType) {
		this.ptyPropertyType = ptyPropertyType;
	}

	

}
