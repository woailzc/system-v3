package com.logistics.system.modlues.ctn.entity;

import com.logistics.system.common.baseEntity.DataEntity;

public class CtnMenu extends DataEntity<CtnMenu> {
	
	private String name;
	
	private String describe;
	
	private String price;
	
	private String photo;
	
	private String status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
