package com.logistics.system.modlues.ast.entity;

import com.logistics.system.common.baseEntity.DataEntity;
import com.logistics.system.modlues.wh.entity.WhWarehouse;

public class AstFixedCapital extends DataEntity<AstFixedCapital>{
	
	private double 	amount;//金额
	
	private String source;//来源
	
	private String name;//固定资产的名称
	
	private String useWay;//使用的方向
	    
	private String model;//型号
	    
	private String status;// 状态
	    
	private String specifications;//规格
	    
	private double unitPrice;//单价
	
	private int num;//数量
	
	private WhWarehouse whWarehouse;//所属的仓库
	
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
	

	public WhWarehouse getWhWarehouse() {
		return whWarehouse;
	}

	public void setWhWarehouse(WhWarehouse whWarehouse) {
		this.whWarehouse = whWarehouse;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUseWay() {
		return useWay;
	}

	public void setUseWay(String useWay) {
		this.useWay = useWay;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
