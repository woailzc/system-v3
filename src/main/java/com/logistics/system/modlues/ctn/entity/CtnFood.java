package com.logistics.system.modlues.ctn.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.logistics.system.common.baseEntity.DataEntity;

public class CtnFood extends DataEntity<CtnFood>{
   
    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date productDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date guarunceeDate;

    private String status;
    
    private CtnFoodType ctnFoodType;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public Date getGuarunceeDate() {
        return guarunceeDate;
    }

    public void setGuarunceeDate(Date guarunceeDate) {
        this.guarunceeDate = guarunceeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public CtnFoodType getCtnFoodType() {
		return ctnFoodType;
	}

	public void setCtnFoodType(CtnFoodType ctnFoodType) {
		this.ctnFoodType = ctnFoodType;
	}
    
}