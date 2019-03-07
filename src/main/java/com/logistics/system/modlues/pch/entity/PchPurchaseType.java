package com.logistics.system.modlues.pch.entity;

import java.util.Date;

import com.logistics.system.common.baseEntity.DataEntity;

public class PchPurchaseType extends DataEntity<PchPurchaseType> {

    private String name;
    
    private String computingUnit;//计算单位

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public String getComputingUnit() {
		return computingUnit;
	}

	public void setComputingUnit(String computingUnit) {
		this.computingUnit = computingUnit;
	}
    
}