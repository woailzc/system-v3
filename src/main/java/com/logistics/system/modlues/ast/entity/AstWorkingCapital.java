package com.logistics.system.modlues.ast.entity;

import com.logistics.system.common.baseEntity.DataEntity;

public class AstWorkingCapital extends DataEntity<AstWorkingCapital> {
	
	private String type;//收入/支出
	
	private String amount;//收入为+，支出为-
	
	private String objective;//流动资金的目的

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}
	
	

}
