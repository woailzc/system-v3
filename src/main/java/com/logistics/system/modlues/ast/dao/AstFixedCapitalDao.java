package com.logistics.system.modlues.ast.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.ast.entity.AstFixedCapital;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;

import java.util.List;

public interface AstFixedCapitalDao extends CrudDao<AstFixedCapital> {
	
	public int statistics();

	public void updateStatus(AstFixedCapital astFixedCapital);

	public void updateWarehouse(AstFixedCapital astFixedCapital);

	public AstFixedCapital getByName(String name);
	
	public void updateRepairStatus(AstFixedCapital astFixedCapital);
	

}