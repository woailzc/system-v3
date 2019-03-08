package com.logistics.system.modlues.cl.entity;

import java.util.Date;

import com.logistics.system.common.baseEntity.DataEntity;

public class PaiBan extends DataEntity<PaiBan> {
	
	private int week;
	
	private int banci;
	
	private String beginTime;
	
	private String endTime;
	
	private String clCleanAreaId;

	//用来接收前端数据
    private String beginTime1;
	
	private String endTime1;
	
	private String beginTime2;
		
	private String endTime2;
	
	private String beginTime3;
			
	private String endTime3;
	
	public PaiBan(){};
	
	public PaiBan(String clCleanAreaId ,int banci){
		
		this.banci = banci;
		this.clCleanAreaId = clCleanAreaId;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getBanci() {
		return banci;
	}

	public void setBanci(int banci) {
		this.banci = banci;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getClCleanAreaId() {
		return clCleanAreaId;
	}

	public void setClCleanAreaId(String clCleanAreaId) {
		this.clCleanAreaId = clCleanAreaId;
	}

	public String getBeginTime1() {
		return beginTime1;
	}

	public void setBeginTime1(String beginTime1) {
		this.beginTime1 = beginTime1;
	}

	public String getEndTime1() {
		return endTime1;
	}

	public void setEndTime1(String endTime1) {
		this.endTime1 = endTime1;
	}

	public String getBeginTime2() {
		return beginTime2;
	}

	public void setBeginTime2(String beginTime2) {
		this.beginTime2 = beginTime2;
	}

	public String getEndTime2() {
		return endTime2;
	}

	public void setEndTime2(String endTime2) {
		this.endTime2 = endTime2;
	}

	public String getBeginTime3() {
		return beginTime3;
	}

	public void setBeginTime3(String beginTime3) {
		this.beginTime3 = beginTime3;
	}

	public String getEndTime3() {
		return endTime3;
	}

	public void setEndTime3(String endTime3) {
		this.endTime3 = endTime3;
	}
	
	

}
