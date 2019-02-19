package com.logistics.system.modlues.cl.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.cl.entity.ClClean;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.re.entity.ReRepairOrder;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;

import java.util.List;

public interface ClCleanDao extends CrudDao<ClClean> {
	
	public void updateStatus(ClClean clClean);
	public void updateDate(ClClean clClean);

}