package com.logistics.system.modlues.wh.entity;

import com.logistics.system.common.baseEntity.DataEntity;
import com.logistics.system.modlues.sys.entity.SysUser;

public class WhWarehouseApply extends DataEntity<WhWarehouseApply> {
	
	private String reason;
	
	private String suggestion;
	
	private SysUser auditor;
	
	private WhWarehouse whWarehouse;
	
	public WhWarehouseApply(){};
	    
	public WhWarehouseApply(String id){
	    this.id = id;
	}


	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public SysUser getAuditor() {
		return auditor;
	}

	public void setAuditor(SysUser auditor) {
		this.auditor = auditor;
	}

	public WhWarehouse getWhWarehouse() {
		return whWarehouse;
	}

	public void setWhWarehouse(WhWarehouse whWarehouse) {
		this.whWarehouse = whWarehouse;
	}
	
	

}
