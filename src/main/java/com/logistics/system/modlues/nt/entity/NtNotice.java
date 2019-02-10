package com.logistics.system.modlues.nt.entity;

import java.util.Date;

import com.logistics.system.common.baseEntity.DataEntity;

public class NtNotice extends DataEntity<NtNotice>{
	
	private String title;
   
    private String text;

    private Date pushDate;

    private String pusher;

    private NtNoticeType ntNoticeType;
    
    public NtNotice(){};
    
    public NtNotice(String id){
    	this.id = id;
    }

  
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
        return text;
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

    public String getPusher() {
        return pusher;
    }

    public void setPusher(String pusher) {
        this.pusher = pusher == null ? null : pusher.trim();
    }

	public NtNoticeType getNtNoticeType() {
		return ntNoticeType;
	}

	public void setNtNoticeType(NtNoticeType ntNoticeType) {
		this.ntNoticeType = ntNoticeType;
	}
    
}