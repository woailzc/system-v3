package com.logistics.system.modlues.wh.entity;

import java.util.Date;

import com.logistics.system.common.baseEntity.DataEntity;

public class WhWarehouse extends DataEntity<WhWarehouse> {
    private String name;
    
    private String computingUnit;
    
    private WhWarehouseType whWarehouseType;//仓库类型

    private Integer maxInventory;//最小库存量

    private Integer minInventory;//最大库存量

    private Integer currentInventory;//当前库存量

    private String status;
    
    public WhWarehouse(){};
    
    public WhWarehouse(String id){
    	this.id = id;
    }

   
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WhWarehouseType getWhWarehouseType() {
		return whWarehouseType;
	}

	public void setWhWarehouseType(WhWarehouseType whWarehouseType) {
		this.whWarehouseType = whWarehouseType;
	}

	public Integer getMaxInventory() {
        return maxInventory;
    }

    public void setMaxInventory(Integer maxInventory) {
        this.maxInventory = maxInventory;
    }

    public Integer getMinInventory() {
        return minInventory;
    }

    public void setMinInventory(Integer minInventory) {
        this.minInventory = minInventory;
    }

    public Integer getCurrentInventory() {
        return currentInventory;
    }

    public void setCurrentInventory(Integer currentInventory) {
        this.currentInventory = currentInventory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public String getComputingUnit() {
		return computingUnit;
	}

	public void setComputingUnit(String computingUnit) {
		this.computingUnit = computingUnit;
	}
    
}