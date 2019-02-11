package com.logistics.system.modlues.ad.entity;

import java.util.Date;

import com.logistics.system.common.baseEntity.DataEntity;
import com.logistics.system.modlues.sys.entity.SysUser;

public class AdAdvice extends DataEntity<AdAdvice>{
    private String title;
    
    private String text;

    private Date pushDate;

    private SysUser pusher;

    private SysUser aduitor;

    private String suggestion;

    private AdAdviceType adAdviceType;
    
    public AdAdvice(){};
    
    public AdAdvice(String id){
    	this.id = id;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Date getPushDate() {
        return pushDate;
    }

    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }
    
    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion == null ? null : suggestion.trim();
    }

	public SysUser getPusher() {
		return pusher;
	}

	public void setPusher(SysUser pusher) {
		this.pusher = pusher;
	}

	public SysUser getAduitor() {
		return aduitor;
	}

	public void setAduitor(SysUser aduitor) {
		this.aduitor = aduitor;
	}

	public AdAdviceType getAdAdviceType() {
		return adAdviceType;
	}

	public void setAdAdviceType(AdAdviceType adAdviceType) {
		this.adAdviceType = adAdviceType;
	}

}