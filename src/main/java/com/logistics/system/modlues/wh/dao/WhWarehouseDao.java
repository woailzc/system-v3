package com.logistics.system.modlues.wh.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.ad.entity.AdAdvice;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.wh.entity.WhWarehouse;

import java.util.List;

public interface WhWarehouseDao extends CrudDao<WhWarehouse> {
	
	public void updateStatus(WhWarehouse warehouse);
	
	public void updateCurrentInventory(WhWarehouse whWarehouse);

}