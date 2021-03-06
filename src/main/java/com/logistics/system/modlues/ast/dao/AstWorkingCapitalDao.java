package com.logistics.system.modlues.ast.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.ast.entity.AstWorkingCapital;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;

import java.util.List;

public interface AstWorkingCapitalDao extends CrudDao<AstWorkingCapital> {
	
	public int statistics();

}