package com.logistics.system.modlues.wh.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.ad.entity.AdAdvice;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.wh.entity.WhWarehouse;
import com.logistics.system.modlues.wh.entity.WhWarehouseApply;

import java.util.List;

public interface WhWarehouseApplyDao extends CrudDao<WhWarehouseApply> {
	
	public void updateSuggestion(WhWarehouseApply warehouseApply);

}