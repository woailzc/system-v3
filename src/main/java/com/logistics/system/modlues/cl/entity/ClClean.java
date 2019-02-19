package com.logistics.system.modlues.cl.entity;

import java.util.Date;

import com.logistics.system.common.baseEntity.DataEntity;
import com.logistics.system.modlues.sys.entity.SysUser;

public class ClClean extends DataEntity<ClClean> {


    private SysUser cleanBy;

    private String cleanAdress;

    private Date startDate;

    private Date endDate;

    private String suggestion;

    private SysUser applicant;
    
    private String status;

   

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCleanAdress() {
        return cleanAdress;
    }

    public void setCleanAdress(String cleanAdress) {
        this.cleanAdress = cleanAdress == null ? null : cleanAdress.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
    }

	public SysUser getCleanBy() {
		return cleanBy;
	}

	public void setCleanBy(SysUser cleanBy) {
		this.cleanBy = cleanBy;
	}

	public SysUser getApplicant() {
		return applicant;
	}

	public void setApplicant(SysUser applicant) {
		this.applicant = applicant;
	}

    
    
}
