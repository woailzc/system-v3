package com.logistics.system.modlues.pty.entity;

import com.logistics.system.common.baseEntity.DataEntity;

public class PtyProperty extends DataEntity<PtyProperty> {
	
	private String name;
	
	private String no;//编号
	
	private String adress;//所属区域
	
	private PtyPropertyType ptyPropertyType;
	
	private String status;//状态
	
	public PtyProperty(){};

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

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
