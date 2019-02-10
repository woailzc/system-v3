/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.logistics.system.common.baseEntity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.logistics.system.modlues.sys.entity.SysUser;

/**
 * 数据Entity类
 * @author lzc
 * 
 */
public abstract class DataEntity<T> extends QuickDataEntity<T> {

	protected String id;//主键
	protected Date createDate;	// 创建日期
	protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）
	protected SysUser createBy;//创建人
	protected SysUser updateBy;//更新人
	protected Date updateDate;//更新日期
	protected String remark;//备注
	
	public DataEntity() {
		super();
		this.delFlag = "0";
	}
	
//	public DataEntity(String id) {
//		this.id = id;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public SysUser getCreateBy() {
		return createBy;
	}

	public void setCreateBy(SysUser createBy) {
		this.createBy = createBy;
	}

	public SysUser getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(SysUser updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	


}
