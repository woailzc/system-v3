package com.logistics.system.modlues.re.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.logistics.system.common.baseEntity.DataEntity;
import com.logistics.system.modlues.sys.entity.SysUser;

public class ReRepairOrder extends DataEntity<ReRepairOrder> {

    private SysUser applyer;

    private SysUser receiver;

    private ReRepairOrderType repairOrderType;

    private String reason;

    private String suggestion;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date applyDate;//开始的申请时间

    private Date recevieDate;
    
    private String status;
    
     private String applyerDelFlag;
    
    private String receiverDelFlag;
    
    private String repairAdress;
    
    public ReRepairOrder() {
		super();
		this.applyerDelFlag = "0";
		this.applyerDelFlag = "0";
	}
    
    public ReRepairOrder(String id){
    	this.id = id;
    }


    public SysUser getApplyer() {
		return applyer;
	}

	public void setApplyer(SysUser applyer) {
		this.applyer = applyer;
	}

	public SysUser getReceiver() {
		return receiver;
	}

	public void setReceiver(SysUser receiver) {
		this.receiver = receiver;
	}

	public ReRepairOrderType getRepairOrderType() {
		return repairOrderType;
	}

	public void setRepairOrderType(ReRepairOrderType repairOrderType) {
		this.repairOrderType = repairOrderType;
	}

	public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getRecevieDate() {
        return recevieDate;
    }

    public void setRecevieDate(Date recevieDate) {
        this.recevieDate = recevieDate;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApplyerDelFlag() {
		return applyerDelFlag;
	}

	public void setApplyerDelFlag(String applyerDelFlag) {
		this.applyerDelFlag = applyerDelFlag;
	}

	public String getReceiverDelFlag() {
		return receiverDelFlag;
	}

	public void setReceiverDelFlag(String receiverDelFlag) {
		this.receiverDelFlag = receiverDelFlag;
	}

	public String getRepairAdress() {
		return repairAdress;
	}

	public void setRepairAdress(String repairAdress) {
		this.repairAdress = repairAdress;
	}
    
}