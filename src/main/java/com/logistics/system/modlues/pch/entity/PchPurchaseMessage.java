package com.logistics.system.modlues.pch.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.logistics.system.common.baseEntity.DataEntity;
import com.logistics.system.modlues.wh.entity.WhWarehouse;

public class PchPurchaseMessage extends DataEntity<PchPurchaseMessage> {

    private String name;//采购产品的名称
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date purchaseEndDate;//采购的结束时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date purchaseStartDate;//申请时间

    private int num;//数量

    private PchPurchaseType purchaseType;//采购物品的类型
    
    private WhWarehouse whWarehouse;//加入的仓库

//    private Double spend;//花费的总价
    
    private String supplier;//供应商
    
    
    private String computingUnit;//计算单位
    
    private String useWay;//使用的方向
    
    private String model;//型号
    
    private String status;// 状态
    
    private String specifications;//规格
    
    private double unitPrice;//单价
    
    public PchPurchaseMessage(){};
    
    public PchPurchaseMessage(String id){
    	this.id = id;
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

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getPurchaseEndDate() {
		return purchaseEndDate;
	}

	public void setPurchaseEndDate(Date purchaseEndDate) {
		this.purchaseEndDate = purchaseEndDate;
	}

	public Date getPurchaseStartDate() {
		return purchaseStartDate;
	}

	public void setPurchaseStartDate(Date purchaseStartDate) {
		this.purchaseStartDate = purchaseStartDate;
	}

	public WhWarehouse getWhWarehouse() {
		return whWarehouse;
	}

	public void setWhWarehouse(WhWarehouse whWarehouse) {
		this.whWarehouse = whWarehouse;
	}


    public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

    public PchPurchaseType getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(PchPurchaseType purchaseType) {
		this.purchaseType = purchaseType;
	}

/*	public Double getSpend() {
        return spend;
    }

    public void setSpend(Double spend) {
        this.spend = spend;
    }*/

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getComputingUnit() {
		return computingUnit;
	}

	public void setComputingUnit(String computingUnit) {
		this.computingUnit = computingUnit;
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
    
}