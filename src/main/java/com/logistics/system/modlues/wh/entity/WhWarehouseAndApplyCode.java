package com.logistics.system.modlues.wh.entity;

import com.logistics.system.common.baseEntity.DataEntity;

public class WhWarehouseAndApplyCode extends DataEntity<WhWarehouseAndApplyCode> {
	
	private WhWarehouse whWarehouse;
	
	private WhWarehouseApply whWarehouseApply;

	public WhWarehouse getWhWarehouse() {
		return whWarehouse;
	}

	public void setWhWarehouse(WhWarehouse whWarehouse) {
		this.whWarehouse = whWarehouse;
	}

	public WhWarehouseApply getWhWarehouseApply() {
		return whWarehouseApply;
	}

	public void setWhWarehouseApply(WhWarehouseApply whWarehouseApply) {
		this.whWarehouseApply = whWarehouseApply;
	}
	
	

}
