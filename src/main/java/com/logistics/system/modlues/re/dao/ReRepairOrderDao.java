package com.logistics.system.modlues.re.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.re.entity.ReRepairOrder;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;

import java.util.List;

public interface ReRepairOrderDao extends CrudDao<ReRepairOrder> {
	
	public void updateStatus(ReRepairOrder repairOrder);
	
	public void updateDate(ReRepairOrder repairOrder);

}