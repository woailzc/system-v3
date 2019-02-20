package com.logistics.system.common.baseEntity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 数据Entity类,搜索框上的条件，可能是日期，文本框等等，数据库不设置对应的字段
 * @author lzc
 * 
 */
public abstract class QuickDataEntity<T> {
	@DateTimeFormat(pattern="yyyy-MM-dd")
	protected Date datemin;//搜索的开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	protected Date datemax;//搜索的结束时间
	
	protected String conditionText;//输入框的内容，可能是文本框，字段可能是name，text，title等等

	public Date getDatemin() {
		return datemin;
	}

	public void setDatemin(Date datemin) {
		this.datemin = datemin;
	}

	public Date getDatemax() {
		return datemax;
	}

	public void setDatemax(Date datemax) {
		this.datemax = datemax;
	}

	public String getConditionText() {
		return conditionText;
	}

	public void setConditionText(String conditionText) {
		this.conditionText = conditionText;
	}


	


}
