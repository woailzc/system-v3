package com.logistics.system.modlues.ast.entity;

import com.logistics.system.common.baseEntity.DataEntity;

public class AstFixedCapital extends DataEntity<AstFixedCapital>{
	
	private double 	amount;//金额
	
	private String source;//来源
	
	private String name;//固定资产的名称
	
	public AstFixedCapital(){};
	
	public AstFixedCapital(String id){
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
