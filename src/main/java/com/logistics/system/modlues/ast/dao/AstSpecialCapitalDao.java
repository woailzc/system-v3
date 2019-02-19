package com.logistics.system.modlues.ast.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.ast.entity.AstSpecialCapital;
import com.logistics.system.modlues.nt.entity.NtNoticeType;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;

import java.util.List;

public interface AstSpecialCapitalDao extends CrudDao<AstSpecialCapital> {
	
	public int statistics();

}