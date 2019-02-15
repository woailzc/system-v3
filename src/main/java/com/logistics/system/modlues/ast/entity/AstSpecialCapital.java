package com.logistics.system.modlues.ast.entity;

import com.logistics.system.common.baseEntity.DataEntity;

public class AstSpecialCapital extends DataEntity<AstSpecialCapital> {
	
	private String projectName;//专属项目的名称
	
	private double amount;//专属项目的金额

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
